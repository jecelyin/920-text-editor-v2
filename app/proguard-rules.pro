#保留
#
#-keep {Modifier} {class_specification} 保护指定的类文件和类的成员
#-keepclassmembers {modifier} {class_specification} 保护指定类的成员，如果此类受到保护他们会保护的更好
#-keepclasseswithmembers {class_specification} 保护指定的类和类的成员，但条件是所有指定的类和类成员是要存在。
#-keepnames {class_specification} 保护指定的类和类的成员的名称（如果他们不会压缩步骤中删除）
#-keepclassmembernames {class_specification} 保护指定的类的成员的名称（如果他们不会压缩步骤中删除）
#-keepclasseswithmembernames {class_specification} 保护指定的类和类的成员的名称，如果所有指定的类成员出席（在压缩步骤之后）
#-printseeds {filename} 列出类和类的成员-keep选项的清单，标准输出到给定的文件
#压缩
#
#-dontshrink 不压缩输入的类文件
#-printusage {filename}
#-whyareyoukeeping {class_specification}
#优化
#
#-dontoptimize 不优化输入的类文件
#-assumenosideeffects {class_specification} 优化时假设指定的方法，没有任何副作用
#-allowaccessmodification 优化时允许访问并修改有修饰符的类和类的成员
#混淆
#
#-dontobfuscate 不混淆输入的类文件
#-obfuscationdictionary {filename} 使用给定文件中的关键字作为要混淆方法的名称
#-overloadaggressively 混淆时应用侵入式重载
#-useuniqueclassmembernames 确定统一的混淆类的成员名称来增加混淆
#-flattenpackagehierarchy {package_name} 重新包装所有重命名的包并放在给定的单一包中
#-repackageclass {package_name} 重新包装所有重命名的类文件中放在给定的单一包中
#-dontusemixedcaseclassnames 混淆时不会产生形形色色的类名
#-keepattributes {attribute_name,…} 保护给定的可选属性，例如LineNumberTable, LocalVariableTable, SourceFile, Deprecated, Synthetic, Signature, and InnerClasses.
#-renamesourcefileattribute {string} 设置源文件中给定的字符串常量

#通配符匹配规则
#
#通配符	规则
#？	匹配单个字符
#*	匹配类名中的任何部分，但不包含额外的包名
#**	匹配类名中的任何部分，并且可以包含额外的包名
#%	匹配任何基础类型的类型名
#*	匹配任意类型名 ,包含基础类型/非基础类型
#...	匹配任意数量、任意类型的参数
#<init>	匹配任何构造器
#<ifield>	匹配任何字段名
#<imethod>	匹配任何方法
#*(当用在类内部时)	匹配任何字段和方法
#$	指内部类

#混淆后，会在/build/proguard/目录下输出下面的文件
#
#dump.txt 描述apk文件中所有类文件间的内部结构。
#mapping.txt 列出了原始的类，方法，和字段名与混淆后代码之间的映射。
#seeds.txt 列出了未被混淆的类和成员
#usage.txt 列出了从apk中删除的代码

# keep住源文件以及行号
-keepattributes SourceFile,LineNumberTable

-keepnames class *
-keepnames interface *
-keepnames enum *

# Keep names - Native method names. Keep all native class/method names.
-keepclasseswithmembers,allowshrinking class * {
    native <methods>;
}