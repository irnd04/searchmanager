package kr.co.mayfarm.system.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

import kr.co.mayfarm.system.properties.ElasticsearchProperties;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

	private final ElasticsearchProperties props;
	
	@Bean
	@Override
	public RestHighLevelClient elasticsearchClient() {
		final String[] urls = props.getUrls().toArray(new String[props.getUrls().size()]);
		final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
	            .connectedTo(urls)
	            .build();
	    return RestClients.create(clientConfiguration).rest();	
	}

}
