package com.github.snowdream.apps.retirement;

import android.test.AndroidTestCase;

/**
 * Created by snowdream on 2016/3/2.
 */
public class PersonTest extends AndroidTestCase {
    public static final int YearOfBirth = 1980;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testManNewRetirementAge() {
        Person person = new Person(Person.Role.MAN, YearOfBirth);
        assertEquals(person.getNewRetirementAge(), 64.75, 0.01f);

    }

    public void testWomanCommonNewRetirementAge() {
        Person person = new Person(Person.Role.WOMAN_COMMON, YearOfBirth);
        assertEquals(person.getNewRetirementAge(), 52.25, 0.01f);

    }

    public void testWomanLeaderNewRetirementAge() {
        Person person = new Person(Person.Role.WOMAN_LEADER, YearOfBirth);
        assertEquals(person.getNewRetirementAge(), 58.5, 0.01f);

    }
}
