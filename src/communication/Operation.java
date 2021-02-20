/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Cartman
 */
public enum Operation  implements Serializable{
    LOGIN_LAWYER,LOGIN_ADMIN,CREATE_LAWYER,
    CHECK_USERNAME_EXISTS,SAVE_LAWYER,GET_LAWYERS,
    DELETE_LAWYER,CREATE_CLIENT,SAVE_CLIENT,GET_CLIENTS_OF_LAWYER,
    CREATE_INVOICE,GET_SERVICES,SAVE_INVOICE,GET_INVOICES_OF_LAWYER,
    CREATE_OBLIGATION,UPDATE_OBLIGATION,GET_OBLIGATIONS,SAVE_ATTENDANCE,
    ATTENDANCE_EXISTS;
}
