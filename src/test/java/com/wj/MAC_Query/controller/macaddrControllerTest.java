package com.wj.MAC_Query.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class macaddrControllerTest {
    macaddrController oui = new macaddrController();

    @Test
    void getOUI() {

        assertEquals("10327E", oui.getOUI("10327E"));
        assertEquals("10327E", oui.getOUI("10327e"));
        assertEquals("10327E", oui.getOUI("10-32-7E"));
        assertEquals("10327E", oui.getOUI("10:32:7E"));
        assertEquals("D89790", oui.getOUI("d8-97-90"));
        assertEquals("D89790", oui.getOUI("d8-97-90-00-00-01"));
    }
}