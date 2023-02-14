# Maven nedir?

Maven genellikle Java platformunda yer alan komutların derlenmesi sırasında kullanılan otomasyon ve inşa aracıdır.

Projede kullanilmasi gerekli olan `jar` dosyalarinin indirilmesi ve projeye dahil edilmesi 
`POM` icine eklenen `dependencies` ile kolay bir şekilde yapilir. Disaridan projeye dahil edilecek olan 
`library'ler` `dependency'ler` yardimi ile otomatik olarak indirilerek projeye dahil edilir.  

Proje `POM` ile birlikte baska bir yere tasinsa dahi, bu `library'lerin` tasinan yerdeki projeye 
eklenmesi icin `POM'u` güncellemek (reload) yeterlidir.

# Maven nasıl çalışır
Maven ilk olarak `pom.xml` okur.

Gerekli olan dependency'leri local repositoryde arar. (Windows için `%homepath%\.m2`, Linux için `$HOME/.m2`)

Dosyalar local repositoryde yoksa Maven Central Repositoryde arar ve projeye dahil eder.


# Maven dizin yapısı

`/src/main/java` – Java komutları yer alır.

`/src/main/resource` – Ayar dosyaları yer alır.

`/src/test` – Birim testleri yer alır.

`/src/test/resource` – Ayar dosyaları yer alır.

`/target` – Derlenen komutların çıktısı yer alır.

# Maven ayar dosyası

Project Object Model (POM.xml) proje talimatlarını içerir.

POM.xml dosyası

```
<project>
<modelVersion>4.0.0</modelVersion>
<groupId>com.guidersoft</groupId> - Grup adı
<artifactId>MavenUygulamam</artifactId> - Proje adı
<version>0.0.1-SNAPSHOT</version> - (SNAPSHOT : halen geliştiriliyor)
<packaging>jar</packaging>
<name>MavenUygulamam</name>

<dependencies>
  <dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>itextpdf</artifactId>
    <version>5.5.13.1</version>
  </dependency>
</dependencies>


<!-- maven plugin'leri -->

</project>
```

Maven Repository:

>https://mvnrepository.com/

Diğer maven ayarları super pom alarak adlandırılan dosyadan alınır.

Proje ayarları aşağıdaki komudun çalıştırılması yeterli olacaktır.

>mvn help:effective-pom

# Maven kullanımı

Derlenmiş dosyaları temizlemek için clean kullanılır.
>mvn clean 

Birim testlerini çalıştırmak için test kullanılır.
>mvn test

Projeyi derlemek için compile kullanılır.
>mvn compile

Projeyi paketlemek(jar, war) için package kullanılır.
>mvn package

Proje dokümantasyonu oluşturmak için site kullanılır.
>mvn site

Hızlı bir şekilde proje iskeleti oluşturmak için kullanılan bir araçtır.
>Maven archetype

Aracı kullanmak için archetype:generate komutu kullanılabilir.
>mvn archetype:generate

Komut çalıştırıldığında sırayla kullanılacak hazır şablonu, proje adını, proje sürümünü isteyecektir.

Maven destekleyen bir IDE’de(Netbeans, Eclipse, IntelliJ vb.) kullanılabilir.

Bazı hazır archetype isimleri aşağıda yer almaktadır.


Archetype ile proje oluşturmak;

>mvn archetype:generate -DgroupId=com.guidersoft -DartifactId=JavaProjem -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false


Harici JAR dosyalarını kullanmak
Maven merkezi depo’da yer alamayan JAR dosyalarını kullanmayı destekler.

Harici JAR dosyasını eklemek için systemPath ile dosya yolunun verilmesi yeterki olacaktır.

```
<dependency>
	<groupId>com.guidersoft</groupId>
	<artifactId>ozeljar</artifactId>
	<scope>system</scope>
	<version>1.0</version>
	<systemPath>src\lib\ozeljar.jar</systemPath>
</dependency>```