

# Testes

Piramide de testes
![image](C:\Users\veloso\eclipse-workspace\app1\pyramid_tests.jpg)


## Testes unit�rios

Os dois tipos de

### Padrão AAA (Arrange, Act, Assert) 

[Refer�ncia](https://medium.com/@alamonunes/teste-unit%C3%A1rio-e-o-padr%C3%A3o-aaa-arrange-act-assert-cb81d587368a)

### Padrão GTW (Given When Then)

[Refer�ncia](https://medium.com/@matheus.saraujo/testes-give-when-then-3bf3fef55f5e)

### Abordagem tradicional 
 
* Abordagem que primeiro criamos as classes e depois os testes

### Abordagem com TDD

* Cria os testes
* Implementa a l�gica
* Refatora

### Melhores pr�ticas

- N�o se testa m�todos privados
- Testando exce��es
- M�todos BeforeEach, AfterEach, BeforeAll, AfterAll  


### Mockito

[referencia](https://site.mockito.org/)

[documenta��o](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)

* init()
* mock()
* when()
* thenReturn()
* verify()
* doThrow()
* captor capture()

maven 


```xml
	<dependency>
	    <groupId>org.junit.jupiter</groupId>
	    <artifactId>junit-jupiter-engine</artifactId>
	    <version>5.3.1</version>
	    <scope>test</scope>
	</dependency>
	<dependency>
	    <groupId>org.mockito</groupId>
	    <artifactId>mockito-core</artifactId>
	    <version>2.21.0</version>
	    <scope>test</scope>
	</dependency>
```


## Testes de integra��o 



## Testes UI 

### Testes automatizados com Selenium

[Selenium documentation](https://www.selenium.dev/documentation/en/)
[Webdriver](https://github.com/mozilla/geckodriver/releases)


