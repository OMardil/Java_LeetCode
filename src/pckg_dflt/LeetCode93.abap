REPORT YTC_SRULE_CLASS.

TYPES: xt_ip TYPE STANDARD TABLE OF string WITH DEFAULT KEY.

CLASS ltc_ip DEFINITION.

  PUBLIC SECTION.
    METHODS ltc_ip
        IMPORTING
            iv_input   TYPE string
        RETURNING
            VALUE(et_ip_list) TYPE xt_ip.


    METHODS ltc_generate_ip
        IMPORTING
            iv_constructed_ip TYPE string
            iv_input          TYPE string
            iv_remaining_dots TYPE integer
        RETURNING
            VALUE(et_ip_list) TYPE xt_ip.



ENDCLASS.


CLASS ltc_ip IMPLEMENTATION.

    METHOD ltc_ip.

        et_ip_list = ltc_generate_ip( iv_constructed_ip = ''
                                      iv_input          = iv_input
                                      iv_remaining_dots = 4 ).


    ENDMETHOD.

    METHOD ltc_generate_ip.

        "Base case 1: All dots are used, no remaining letters
        IF iv_remaining_dots = 0 AND strlen( iv_input ) = 0.
            insert iv_constructed_ip INTO TABLE et_ip_list.
            return.
        ENDIF.

        "When a valid solution is impossible to create
        DATA(lv_len) = strlen( iv_input ).
        IF lv_len > iv_remaining_dots * 3 or iv_remaining_dots > lv_len.
            return.
        ENDIF.

        "Recursive case... when should I keep going?
        DATA: lv_segment_size TYPE integer.
        lv_segment_size = 0.
        DO 3 TIMES.
            add 1 to lv_segment_size.

            IF NOT strlen( iv_input ) >= lv_segment_size.
                CONTINUE.
            ENDIF.

            "Grab segment size, and recursively call method
            DATA lv_current_ip TYPE string.
            lv_current_ip = iv_input(lv_segment_size).

            DATA lv_segment TYPE n LENGTH 3.
            lv_segment = lv_current_ip.

            "IP segments cannot be greater than 255 or smaller than 1
            IF lv_segment < 1 OR lv_segment > 255.
                CONTINUE.
            ENDIF.

            "IP segments cannot begin with 0
            IF lv_current_ip(1) = '0'.
                CONTINUE.
            ENDIF.

            CONCATENATE iv_constructed_ip lv_current_ip INTO lv_current_ip.

            DATA(lv_remaining_ip) = substring( val = iv_input off = lv_segment_size ).

            IF strlen( lv_remaining_ip ) <> 0.
                CONCATENATE lv_current_ip '.' INTO lv_current_ip.
            ENDIF.


            DATA(lt_ip_list) = ltc_generate_ip( iv_constructed_ip = lv_current_ip
                                                iv_input          = lv_remaining_ip
                                                iv_remaining_dots = iv_remaining_dots - 1 ).
            if lt_ip_list IS NOT INITIAL.
                APPEND LINES OF lt_ip_list to et_ip_list.
            ENDIF.

        ENDDO.

    ENDMETHOD.

ENDCLASS.

START-OF-SELECTION.
    DATA(lo_ip) = NEW ltc_ip(  ).
    DATA(lt_ip_list) = lo_ip->ltc_ip( '25525511135' ).

    LOOP AT lt_ip_list INTO DATA(lw_ip).
        WRITE: lw_ip, /.
    ENDLOOP.

    lt_ip_list = lo_ip->ltc_ip( '101025220' ).

    LOOP AT lt_ip_list INTO lw_ip.
        WRITE: lw_ip, /.
    ENDLOOP.

    lt_ip_list = lo_ip->ltc_ip( '102021220' ).

    LOOP AT lt_ip_list INTO lw_ip.
        WRITE: lw_ip, /.
    ENDLOOP.

    lt_ip_list = lo_ip->ltc_ip( '8888' ).

    LOOP AT lt_ip_list INTO lw_ip.
        WRITE: lw_ip, /.
    ENDLOOP.

    lt_ip_list = lo_ip->ltc_ip( '80888' ).

    LOOP AT lt_ip_list INTO lw_ip.
        WRITE: lw_ip, /.
    ENDLOOP.