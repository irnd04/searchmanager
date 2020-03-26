package kr.co.mayfarm.login.domain;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.elasticsearch.annotations.Document;

import kr.co.mayfarm.system.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@Document(indexName = "users")
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
}
