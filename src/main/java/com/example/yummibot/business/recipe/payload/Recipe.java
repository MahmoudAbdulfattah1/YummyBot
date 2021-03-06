package com.example.yummibot.business.recipe.payload;

import com.example.yummibot.business.recipe.ResultRecipe;
import com.example.yummibot.business.recipe.Results;
import lombok.Data;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@Data
public class Recipe {
    private String url;
    private String status;
    private String time;

    private RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
    public Recipe(){}

    public Recipe(ResultRecipe resultRecipe) {
        String ID = String.valueOf(resultRecipe.getId());
        String go = "https://api.spoonacular.com/recipes/" + ID + "/card?apiKey=b7f84234d75d4f7ba1de453a856c3fe8";
        RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());
        Recipe recipe = restTemplate.exchange(go, HttpMethod.GET, setHeaders(), Recipe.class).getBody();
        url = recipe.url;
        status = recipe.status;
        time = recipe.time;
    }
    public HttpEntity<String> setHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-agent", "application");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;
    }

}
