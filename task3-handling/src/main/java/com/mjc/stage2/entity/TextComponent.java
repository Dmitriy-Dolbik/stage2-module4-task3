package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextComponent extends AbstractTextComponent{
    protected List<AbstractTextComponent> componentList = new ArrayList<>();
    private int size = 0;

    public TextComponent(TextComponentType componentType)
    {
        super(componentType);
    }

    @Override
    public String operation()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (AbstractTextComponent component : componentList) {
            stringBuilder.append(component.operation());
        }
        return stringBuilder.toString();
    }

    @Override
    public void add(final AbstractTextComponent textComponent)
    {
        componentList.add(textComponent);
        size += textComponent.getSize();
    }

    @Override
    public void remove(final AbstractTextComponent textComponent)
    {

        componentList.remove(textComponent);
        size -= textComponent.getSize();
    }

    @Override
    public int getSize()
    {
        return size;
    }
}
