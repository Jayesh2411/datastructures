package org.example.queues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class EmptyArraysTest {

    @Test
    void emptyArrays() {
        Assertions.assertEquals(6, EmptyArrays.emptyArrays(
                new String[]{"1", "3", "2"},
                new String[]{"2", "3", "1"})
        );
    }
}