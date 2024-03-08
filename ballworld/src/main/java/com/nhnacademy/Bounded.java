package com.nhnacademy;

import java.awt.Rectangle;

public interface Bounded {
    void bounce();

    void bounce(Regionable obj);

    void setBoundary(Rectangle boundary);
}
