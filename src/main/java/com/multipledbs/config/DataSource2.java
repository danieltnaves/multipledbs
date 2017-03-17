package com.multipledbs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author tqi_dnaves
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/17/17 2:41 PM
 */
@Component
@ConfigurationProperties("datasource.db2")
public class DataSource2 extends AbstractDatasourceProperties {
}
