package org.codewars.Kingdom.ep2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TheCurseSimpleTest {
    @Test
    public void sample() {
        assertEquals("hello world!", TheCurseSimple.translate("***lo w***d!", new String[]{"hello", "world"}));
        assertEquals("cell, weak!", TheCurseSimple.translate("c**l, w*ak!", new String[]{"hell", "cell", "week", "weak"}));
        assertEquals("hello, world!", TheCurseSimple.translate("hell*, w***d!", new String[]{"hello", "hell", "word", "world"}));
        assertEquals("mel", TheCurseSimple.translate("***", new String[]{"mel", "dell"}));
        assertEquals("", TheCurseSimple.translate("", new String[]{"hell", "weak"}));
        assertEquals("bbbb. aaa,", TheCurseSimple.translate("****. ***,", new String[]{"aaa", "bbbb"}));
    }

    @Test
    public void newEdge() {
        String result = "qow qqqovq qpqq ooqqu oqqqy ptqqq. sqopq. qropoo, qpx";
        String sp = "*ow ****v* **** ****u oq**y *t***. s*opq. qro***, q*x";
        String[] voc = new String[]{"ooqqu","ptqqq","qqqovq","qpqq","qpx","oqqqy","qropoo","sqopq","qow"};
        assertEquals(result, TheCurseSimple.translate(sp, voc));
    }
}
