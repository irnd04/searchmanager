package kr.co.mayfarm.system.domain;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Setter
@Getter
@Builder
@Document(indexName = "menus", type = "doc", shards = 1, replicas = 0)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Menu extends BaseEntity {
	public enum Type {
		HEADING, MENU, LINK
	}
	@Field(type = FieldType.Keyword)
	private String parentId;
	@Field(type = FieldType.Keyword)
	private String link;
	@Field(type = FieldType.Keyword)
	private Menu.Type type;
	@Field(type = FieldType.Long)
	private int order;
	@Field(type = FieldType.Keyword)
	private String icon;
	@Field(type = FieldType.Keyword)
	private String name;
}
