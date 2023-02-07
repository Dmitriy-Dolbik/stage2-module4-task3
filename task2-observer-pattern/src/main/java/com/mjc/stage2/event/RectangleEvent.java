package com.mjc.stage2.event;


import com.mjc.stage2.entity.Rectangle;

import java.util.EventObject;

public class RectangleEvent extends EventObject {

    public RectangleEvent(Object source) {

        super(source);
    }

    @Override
    public Rectangle getSource() {

        return (Rectangle) super.getSource();
    }
}
