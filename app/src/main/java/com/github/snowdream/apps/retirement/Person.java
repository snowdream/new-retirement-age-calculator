package com.github.snowdream.apps.retirement;

/**
 * Created by snowdream on 2016/3/2.
 */
public class Person {
    private Role mRole = Role.MAN;
    private int mYearOfbirth = 0;
    protected final static int STEP = 3;


    private Person() {
        throw new AssertionError("Not Allowed.");
    }

    public Person(Role role,int yearOfbirth) {
        this.mRole = role;
        this.mYearOfbirth = yearOfbirth;
    }


    /**
     * 计算公式依据： http://toutiao.com/i6257036394573595137/
     *
     * @return 新的退休年龄
     */
    final public float getNewRetirementAge() {
        return mRole.getOldRetirementAge() + STEP * (mRole.getOldRetirementAge() + mYearOfbirth - 2021) * 0.0833333333333333f;
    }

    public enum Role {
        MAN(0),  // 男性
        WOMAN_COMMON(1), // 女职工
        WOMAN_LEADER(2); // 女干部

        private int mValue = 0;

        private Role(int value) {
            this.mValue = value;
        }

        public static Role valueOf(int value) {
            switch (value) {
                case 0:
                    return MAN;
                case 1:
                    return WOMAN_COMMON;
                case 2:
                    return WOMAN_LEADER;
                default:
                    return MAN;
            }
        }

        public int getOldRetirementAge(){
            switch (mValue) {
                case 0:
                    return 60;
                case 1:
                    return 50;
                case 2:
                    return 55;
                default:
                    return 60;
            }
        }


        public int value() {
            return this.mValue;
        }
    }
}
