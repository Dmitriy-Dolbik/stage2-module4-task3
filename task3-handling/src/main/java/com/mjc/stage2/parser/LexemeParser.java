package com.mjc.stage2.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.w3c.dom.Text;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class LexemeParser extends AbstractTextParser
{
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string)
    {
        String[] lexemes = string.split(LEXEME_REGEX);
        List<String> filteredWords = Arrays.stream(lexemes)
                .filter(lexeme -> lexeme.matches(WORD_REGEX))
                .collect(Collectors.toList());
        for (String word : filteredWords)
        {
            TextComponent wordComposite = new TextComponent(TextComponentType.WORD);
            nextParser.parse(wordComposite, word);

            abstractTextComponent.add(wordComposite);
        }
        /*for (String lexeme : lexemes) {
            TextComponent lexemeComposite = new TextComponent(TextComponentType.WORD);
            nextParser.parse(lexemeComposite, lexeme);

            abstractTextComponent.add(lexemeComposite);
        }*/
    }
}
