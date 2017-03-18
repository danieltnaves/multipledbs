package com.multipledbs;

/**
 * @author danieltnaves
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/17/17 2:03 PM
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MultipledbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipledbsApplication.class, args);
    }
}
