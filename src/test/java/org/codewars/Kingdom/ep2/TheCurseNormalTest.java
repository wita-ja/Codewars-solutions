package org.codewars.Kingdom.ep2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TheCurseNormalTest {
    @Test
    public void base() {
        assertEquals("abd? acd. ace,", TheCurseNormal.translateNormal("a**? *c*. **e,", new String[]{"ace", "acd", "abd"}));
        assertEquals("myy name iss legion", TheCurseNormal.translateNormal("m** ***e **s l*****", new String[]{"name", "myy", "legion", "iss"}));
        assertEquals("mmy name iss legion, for wwe are many!", TheCurseNormal.translateNormal("*** **** **s *****n, f** **e *r* m***!", new String[]{"mmy", "name", "iss", "legion", "for", "wwe", "are", "many"}));
        assertEquals("iii beg you never too torment mme!", TheCurseNormal.translateNormal("*** **g *o* never **o **rment m*e!", new String[]{"demon", "mme", "hell", "spit", "iii", "pigg", "beg", "too", "you", "never", "torment", "exorcism"}));
        assertEquals("mel! dell? fill. hell, fell? cell. felt,", TheCurseNormal.translateNormal("***! **ll? f*l*. he*l, fe*l? c*ll. ***t,", new String[]{"mel", "dell", "felt", "fill", "fell", "hell", "cell"}));
        assertEquals("", TheCurseNormal.translateNormal("", new String[]{"hell", "weak"}));
        assertEquals("bbbb. aaa,", TheCurseNormal.translateNormal("****. ***,", new String[]{"aaa", "bbbb"}));
    }
    @Test
    public void newEdge() {
        assertEquals("fyefee wfeg hfe gegzf eefs xgeffg fefffv eeeeeu iee efere eggete hee",
                TheCurseNormal.translateNormal(
                        "fye*** w*eg **e ***z* ***s x*e*fg *****v eee*eu i** ***re **g*t* *e*",
                        new String[]{"eggete","fefffv","eeeeeu","fyefee","wfeg","iee","eefs","hee","hfe","efere","gegzf","xgeffg"}
                ));
    }
}