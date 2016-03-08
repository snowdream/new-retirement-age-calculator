# 新退休年龄计算器


## 简介
新退休年龄计算器，根据最近的新退休年龄计算公式制作完成。
<pre>
新退休年龄计算公式
我国现行职工退休年龄男性60周岁、女干部55周岁、女工人50周岁。这是在上世纪50年代初《劳动保险条例》和有关政策规定的。

按照中国人力资源和社会保障部部长尹蔚民“迟退休一年增加3个月”的例子，推算出延迟退休后的退休年龄计算公式：
女职工退休年龄=50+3×（50+出生年份-2021）/12
女干部退休年龄=55+3×（55+出生年份-2021）/12
男性退休年龄=60+3×（60+出生年份-2021）/12
我们选取同为1980年出生的女职工、女干部和男性来计算，则结果为：
1980年出生女职工退休年龄=
50+3×（50+1980-2021）/12=50+3×9/12=52.25岁
1980年出生女干部退休年龄=
55+3×（55+1980-2021）/12=55+3×14/12=58.5岁
1980年出生男性退休年龄=
60+3×（60+1980-2021）/12=60+3×19/12=64.75岁
注：
当（目前退休年龄+出生年份-2021）等于或大于最终确定的延迟退休最大增加年数（例如方案最终规定男性最多延迟到65岁退休，则最大增加年数为5年）时，结果均为最大退休年龄。</pre>

## 系统要求
Android 2.3+

## 免责声明
本应用计算公式来自新闻 [“新退休年龄计算公式”](http://toutiao.com/i6256923608682070530/)      
计算结果仅供参考，不做其它依据。


## 预览
![新退休年龄计算器](docs/preview/device-2016-03-08-213132.png)

## License
```
Copyright (C) 2015 Snowdream Mobile <yanghui1986527@gmail.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```