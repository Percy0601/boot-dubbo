package boot.dubbo.infrastructure.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import boot.dubbo.infrastructure.repo.ComplexQueryRepo;

@Configuration
@ConfigurationProperties(prefix = "mybatis", ignoreUnknownFields = false)
public class MyBatisConfig {
	private Logger log = LoggerFactory.getLogger(MyBatisConfig.class);

	private String configLocationXml = "MyBatis-Configuration.xml";

	public String getConfigLocationXml() {
		return configLocationXml;
	}

	public void setConfigLocationXml(String configLocationXml) {
		this.configLocationXml = configLocationXml;
	}

	@Bean
	@Autowired
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
		log.info("加载MyBatis配置文件:{}", configLocationXml);
		Resource configLocation = new ClassPathResource(configLocationXml);
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(configLocation);
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}

	@Bean
	@Autowired
	public ComplexQueryRepo apiServiceMapperFactoryBean(
			SqlSessionFactoryBean sqlSessionFactory) throws Exception {
		MapperFactoryBean<ComplexQueryRepo> mapperFactoryBean = new MapperFactoryBean<ComplexQueryRepo>();
		mapperFactoryBean.setMapperInterface(ComplexQueryRepo.class);
		mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory.getObject());
		return mapperFactoryBean.getObject();
	}

}
