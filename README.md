# http://wonwoo.ml/index.php/post/1143

AdminLte 오류나는 메뉴들
Layout Options -- All
Flot
Editor - CK Editor

https://cyberx.tistory.com/132

https://gs.saro.me/dev?page=3&tn=481

https://www.youtube.com/watch?v=LLnBVsEqSSE

https://jeong-pro.tistory.com/170

https://adminlte.io/themes/AdminLTE/

https://gurumee92.tistory.com/76

<div class="widget-user-header bg-black" style="background: url('../dist/img/photo1.png') center center;">

Spring data jpa - hibernate
h2 -> Oracle
Cache : JSR-107 JCache - ehcache
thymeleaf 2.1 : @{/...} 해줘야 다른 페이지에서도 link를 찾음
clean-blog - https://startbootstrap.com/template-overviews/clean-blog/
CI : semaphoreci
heroku

JCacheManagerCustomizer ?????

http://wonwoo.ml/index.php/post/1607
[자바] 자주 사용되는 Lombok 어노테이션
http://www.daleseo.com/lombok-popular-annotations/

Lombok 라이브러리에서 제공하는 어노테이션 중에서 자주 사용되는 어노테이션 위주로 살펴보도록 하겠습니다.

접근자/설정자 자동 생성
제일 먼저 살펴볼 어노테이션은 @Getter와 @Setter 입니다.
아마 Lombok에서 가장 많이 사용되는 어노테이션일 텐데요.
예를 들어, xxx라는 필드에 선언하면 자동으로 getXxx()(boolean 타입인 경우, isXxx())와 setXxx() 메소드를 생성해줍니다.

    @Getter @Setter
    private String name;

위와 같이 특정 필드에 어노테이션을 붙여주면, 다음과 같이 자동으로 생성된 접근자와 설정자 메소드를 사용할 수 있어서 매우 편리합니다.

    user.setName("홍길동");
    String userName = user.getName();

또한, 필드 레벨이 아닌 클래스 레벨에 @Getter 또는 @Setter를 선언해줄 경우, 모든 필드에 접근자와 설정자가 자동으로 생성됩니다.

VO 클래스를 작성할 때 마다, 접근자와 설정자 메소드를 작성해주는게 참 번거로운 일이었는데, (특히, 수정할 때는 더욱이) Lombok을 쓰게되면 이런 노가다성 코딩에서 해방될 수 있습니다. :)

생성자 자동 생성
Lombok을 사용하면 생성자도 자동으로 생성할 수 있습니다.
@NoArgsConstructor 어노테이션은 파라미터가 없는 기본 생성자를 생성해주고,
@AllArgsConstructor 어노테이션은 모든 필드 값을 파라미터로 받는 생성자를 만들어줍니다.
마지막으로 @RequiredArgsConstructor 어노테이션은 final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만들어줍니다.

    @NoArgsConstructor
    @RequiredArgsConstructor
    @AllArgsConstructor
    public class User {
        private Long id;

        @NonNull
        private String username;

        @NonNull
        private String password;

        private int[] scores;
    }

    User user1 = new User();
    User user2 = new User("dale", "1234");
    User user3 = new User(1L, "dale", "1234", null);

ToString 메소드 자동 생성
toString() 메소드를 작성하는 것도 여간 귀찮은 일이 아닙니다.
하지만 Lombok을 사용하면 @ToString 어노테이션만 클래스에 붙여주면 자동으로 생성해줍니다.

예제와 같이 exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외시킬 수도 있습니다.

    @ToString(exclude = "password")
    public class User {
        private Long id;
        private String username;
        private String password;
        private int[] scores;
    }

위와 같이 클래스에 @ToString 어노테이션을 붙이고, 아래와 같이 필드를 세팅 후 출력을 하면,

    User user = new User();
    user.setId(1L);
    user.setUsername("dale");
    user.setUsername("1234");
    user.setScores(new int[]{80, 70, 100});
    System.out.println(user);

다음과 같이, 클래스명(필드1명=필드1값,필드2명=필드2값,...) 식으로 출력됩니다.

    User(id=1, username=1234, scores=[80, 70, 100])

Lombok을 사용하기 전에는 Apache Commons Lang 라이브러리의 ToStringBuilder를 사용했었는데, Lombok을 사용하는 게 어노테이션 한 방으로 끝나니 훨씬 편한 것 같습니다.

equals, hashCode 자동 생성
자바 빈을 만들 때 equals와 hashCode 메소드를 자주 오버라이딩 하는데요. @EqualsAndHashCode 어노테이션을 사용하면 자동으로 이 메소드를 생성할 수 있습니다.

    @EqualsAndHashCode(callSuper = true)
    public class User extends Domain {
        private String username;
        private String password;
    }

callSuper 속성을 통해 equals와 hashCode 메소드 자동 생성 시 부모 클래스의 필드까지 감안할지 안 할지에 대해서 설정할 수 있습니다.

즉, callSuper = true로 설정하면 부모 클래스 필드 값들도 동일한지 체크하며, callSuper = false로 설정(기본값)하면 자신 클래스의 필드 값들만 고려합니다.

    User user1 = new User();
    user1.setId(1L);
    user1.setUsername("user");
    user1.setPassword("pass");

    User user2 = new User();
    user1.setId(2L); // 부모 클래스의 필드가 다름
    user2.setUsername("user");
    user2.setPassword("pass");

    user1.equals(user2);
    // callSuper = true 이면 false, callSuper = false 이면 true

끝판왕! @Data
@Data는 위에서 설명드린 @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정해주는 매우 유용한 어노테이션입니다.

    @Data
    public class User {
    // ...
    }

사용 방법은 다른 어노테이션들과 대동소이합니다.
클래스 레벨에서 @Data 어노테이션을 붙여주면, 모든 필드를 대상으로 접근자와 설정자가 자동으로 생성되고,
final 또는 @NonNull 필드 값을 파라미터로 받는 생성자가 만들어지며,
toStirng, equals, hashCode 메소드가 자동으로 만들어집니다.





spring Boot blog
-----

1. [spring-boot] 블로그를 만들자 (1)
2. [spring-boot] 블로그를 만들자. (2) JPA
3. [spring-boot] 블로그를 만들자. (3) Category 와 Comment
4. [spring-boot] 블로그를 만들자. (4) thymeleaf
5. [spring-boot] 블로그를 만들자. (5) markdown, catetory

### java
```java
class Main {
  public static void main(String[] args){
    System.out.println("Spring Boot Blog");
  }
}
```

### xml
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

### js
```js
function hello(){
    console.log("hello world");
}
```
### css

```css
sub, sup {
    font-size: 75%;
    line-height: 0;
    position: relative;
    vertical-align: baseline;
}
```