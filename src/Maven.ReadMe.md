# Maven nedir?

Maven genellikle Java platformunda yer alan komutların derlenmesi sırasında kullanılan otomasyon ve inşa aracıdır.

Projede kullanilmasi gerekli olan `jar` dosyalarinin indirilmesi ve projeye dahil edilmesi 
`POM` icine eklenen `dependencies` ile kolay bir şekilde yapilir. Disaridan projeye dahil edilecek olan 
`library'ler` `dependency'ler` yardimi ile otomatik olarak indirilerek projeye dahil edilir.  

Proje `POM` ile birlikte baska bir yere tasinsa dahi, bu `library'lerin` tasinan yerdeki projeye 
eklenmesi icin `POM'u` güncellemek (reload) yeterlidir.

# Maven nasıl çalışır
Maven ilk olarak ayar dosyasını (**pom.xml**) okur.

Gerekli olan bağımlılıkları yerel depoda (local repository) arar.

Windows için `%homepath%\.m2` klasöründe, Linux için `$HOME/.m2` klasöründe arar.

Dosyalar yerel depoda yoksa uzak depoda (Maven Central Repository – https://repo.maven.apache.org/maven2/) arar.

Dosyalar uzak depoda varsa yerel depoya indirir ve projeye dahil eder.

Maven ayrıca projeye dahil edilen her kütüphanenin ihtiyaç duyduğu bağımlılıkları da indirir.


# Maven dizin yapısı
Proje geliştirirken her geliştirici farklı dizin yapısını kullanabilir.

Farklı geliştiriciler tarafından belirlenen farklı dizin yapıları projenin başka kişi tarafından takip edilmesini zorlaştırır.

Maven sağladığı standart dosya-dizin yapısı sayesinde kolay bir şekilde projelerin takip edilmesini sağlar.

Bu yapı sayesinde her geliştirici kolay bir şekilde ilgili dosyaya erişim sağlar.

Ayrıca bir çok IDE (Netbeans, Eclipse, IntelliJ) bu dizin yapısın destekler.

`/src/main/java` – Java komutları yer alır.

`/src/main/resource` – Ayar dosyaları yer alır.

`/src/test` – Birim testleri yer alır.

`/src/test/resource` – Ayar dosyaları yer alır.

`/target` – Derlenen komutların çıktısı yer alır.

# Maven ayar dosyası

Project Object Model (POM.xml) proje talimatlarını içerir.

Örnek POM.xml dosyası

```
<project>
<modelVersion>4.0.0</modelVersion>
<groupId>com.guidersoft</groupId> - Proje adı (Paket adı kullanılır genellike)
<artifactId>MavenUygulamam</artifactId> - Proje adı
<version>0.0.1-SNAPSHOT</version> - Semantic versionlama kullanmak faydalı olacaktır. (5.0.0.RELEASE - 5.0.0.FINAL) SNAPSHOT(halen geliştiriliyor.)
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

Kütüphaneleri bulmak için aşağıdaki adresi kullanabilirsiniz.

>https://mvnrepository.com/

Diğer maven ayarları super pom alarak adlandırılan dosyadan alınır.

Tüm proje ayarları için ayar dosyasının olduğu dizinde aşağıdaki komudun çalıştırılması yeterli olacaktır.

>mvn help:effective-pom
> 
Super POM ayar dosyasında çeşitli maven plugin’lerin olduğu görünecektir.

# Maven kullanımı
Maven ayar dosyaları Super POM olarak adlandırılan dosyadaki pluginleri kullanarak işlem yapar.

Bu işlemler phase olarak adlandırılır.

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


Archetype ile Java projesi oluşturmak;

>mvn archetype:generate -DgroupId=com.yusufsezer -DartifactId=JavaProjem -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

Archetype ile Java web projesi oluşturmak;
>mvn archetype:generate -DgroupId=com.yusufsezer -DartifactId=JavaWebProjem -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

Harici JAR dosyalarını kullanmak
Maven merkezi depo’da yer alamayan JAR dosyalarını kullanmayı destekler.

Bu diğer JAR dosyaları da projeye eklenebilir.

Harici JAR dosyasını eklemek için systemPath ile dosya yolunun verilmesi yeterki olacaktır.

```
<dependency>
	<groupId>com.guidersoft</groupId>
	<artifactId>ozeljar</artifactId>
	<scope>system</scope>
	<version>1.0</version>
	<systemPath>src\lib\ozeljar.jar</systemPath>
</dependency>```