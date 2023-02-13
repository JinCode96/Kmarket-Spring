package kr.co.kmarket.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.util.UriComponentsBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCondition {
    private Integer page = 1;
    private Integer pageSize = 10;
//<<<<<<< HEAD:kmarket/src/main/java/kr/co/kmarket/vo/SearchCondition.java
    private String group;
    private String cate;
    private String cate1;
    private String cate2;
//=======
//    private String group;
//    private String cate;
//>>>>>>> 278603b87cf596d5c5a11105e75f6fe3ac20b9d0:kmarket/src/main/java/kr/co/kmarket/utils/SearchCondition.java
    private Integer no = 0;
    private String searchField;
    private String searchWord;

    // 추가 필드
    private int type;
    private String uid;


    public String getQueryString(Integer page){
        // ?page=1&pageSize=10&option="T"&keyword="title"
        return getQueryString(page, no);
    }

    public String getQueryString(Integer page, Integer no){
        // ?page=1&pageSize=10&option="T"&keyword="title"
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
//                .queryParam("group", group)
//                .queryParam("cate", cate)
                .queryParam("page", page);


        if (no != null && no != 0)
            builder.queryParam("no", no);

        // 검색 기능
        if(searchField != null && !searchWord.isBlank()){
            builder.queryParam("searchField", searchField)
                    .queryParam("searchWord", searchWord);
        }

        return builder.toUriString();
    }

    public String getQueryString(){
        // ?page=1&pageSize=10&option="T"&keyword="title"
        return getQueryString(page);
    }

    // limit
    public Integer getOffset() {
        return (page-1) * pageSize;
    }

    public void setPage(Integer page) {
        this.page = page == 0 ? 1:page;
    }

    public String getcsQueryString(Integer page){
        // ?page=1&pageSize=10&option="T"&keyword="title"
        return getcsQueryString(page, no);
    }
    public String getcsQueryString(Integer page, Integer no){
        // ?page=1&pageSize=10&option="T"&keyword="title"
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
                .queryParam("cate1", cate1)
                .queryParam("cate2", cate2)
                .queryParam("page", page);


        if (no != null && no != 0)
            builder.queryParam("csNo", no);

        return builder.toUriString();
    }
}
