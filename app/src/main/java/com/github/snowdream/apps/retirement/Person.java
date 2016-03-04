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
     * 计算公式依据：http://toutiao.com/i6256923608682070530/
     *
     * @return 新的退休年龄
     */
    final public float getNewRetirementAge() {
        //按照旧的退休年龄
        if (mRole.getOldRetirementAge() + mYearOfbirth - 2021 < 0){
            return mRole.getOldRetirementAge();
        }

        //按照新的退休年龄
        float newRetirementAge = mRole.getOldRetirementAge() + STEP * (mRole.getOldRetirementAge() + mYearOfbirth - 2021) * 0.0833333333333333f;

        //如果超过最新规定的最大退休年龄，则返回最新规定的最大退休年龄
        if (newRetirementAge >= mRole.getNewMaxRetirementAge()){
            return mRole.getNewMaxRetirementAge();
        }else {
            return newRetirementAge;
        }
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

        /**
         * 旧的退休年龄
         *
         * @return
         */
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

        /**
         * 最终规定的最大退休年龄
         *
         * @return
         */
        public int getNewMaxRetirementAge(){
            switch (mValue) {
                case 0:
                    return 80;
                case 1:
                    return 80;
                case 2:
                    return 80;
                default:
                    return 80;
            }
        }

        public int value() {
            return this.mValue;
        }
    }
}
