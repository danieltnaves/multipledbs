package com.multipledbs.domain;

/**
 * @author danieltnaves
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/17/17 11:45 AM
 */
public enum CustomerType {
    DB1("db1"),
    DB2("db2");

    private String dbName;

    CustomerType(String dbName) {
        this.dbName = dbName;
    }

    public String dbName() {
        return this.dbName;
    }
}
