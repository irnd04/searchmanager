package kr.co.mayfarm.login.repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.mayfarm.login.domain.User;
import kr.co.mayfarm.system.properties.ElasticsearchProperties;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepostoryCustom {
	
	private final RestHighLevelClient client;
	private final ElasticsearchProperties props;
	private final ObjectMapper mapper;

	@Override
	public List<User> findByPassword() throws IOException {
		SearchRequest sr = new SearchRequest(props.getUserIndex());
		SearchSourceBuilder sb = new SearchSourceBuilder();
		sr.source(sb);
		SearchResponse sres = client.search(sr, RequestOptions.DEFAULT);
		return Arrays.stream(sres.getHits().getHits()).map(x -> {
			return mapper.convertValue(x.getSourceAsMap(), User.class);
		}).collect(Collectors.toList());
	}
}
