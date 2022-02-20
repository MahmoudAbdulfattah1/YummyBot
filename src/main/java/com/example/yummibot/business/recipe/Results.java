package com.example.yummibot.business.recipe;

import com.example.yummibot.business.recipe.ResultRecipe;
import lombok.Data;

import java.util.List;

@Data
public class Results {
    private List<ResultRecipe> results;
    private List<ResultRecipe> recipes;
    private int offset;
    private int number;
    private int totalResults;


}
