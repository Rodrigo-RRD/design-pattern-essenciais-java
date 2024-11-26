# Design Patterns em Java 17 com Maven

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

## Abstract Factory

Um padrão de criação que fornece uma interface para criar famílias de objetos relacionados ou dependentes sem especificar suas classes concretas.

Objetivo: Isolar a criação de objetos complexos que podem pertencer a diferentes famílias ou variar conforme o contexto.
Exemplo de problema: Criar interfaces de UI específicas para diferentes sistemas operacionais (Windows, macOS, Linux).

```java
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
public class WindowsFactory implements GUIFactory {
    public Button createButton() { return new WindowsButton(); }
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}
```

## Builder

Um padrão de criação que separa a construção de um objeto complexo da sua representação, permitindo criar diferentes representações do mesmo tipo.

Objetivo: Facilitar a criação de objetos complexos passo a passo.
Exemplo de problema: Criar um objeto House com partes opcionais como garagem, piscina, ou jardim.

```java
public class HouseBuilder {
    private House house = new House();
    public HouseBuilder addGarage() { house.setGarage(true); return this; }
    public HouseBuilder addPool() { house.setPool(true); return this; }
    public House build() { return house; }
}
```    

## Decorator

Um padrão estrutural que permite adicionar comportamentos a objetos dinamicamente sem alterar sua classe.

Objetivo: Extender a funcionalidade de um objeto de forma flexível e reutilizável.
Exemplo de problema: Adicionar diferentes tipos de bordas (vermelha, tracejada) a um componente de interface gráfica.

```java
public interface Shape { void draw(); }
public class Circle implements Shape { public void draw() { System.out.println("Circle"); } }
public class RedBorderDecorator implements Shape {
    private Shape decoratedShape;
    public RedBorderDecorator(Shape shape) { this.decoratedShape = shape; }
    public void draw() {
        decoratedShape.draw();
        System.out.println("Adding red border");
    }
}
```

## Dependency Injection

Um padrão de projeto que permite injetar dependências em um objeto em vez de criá-las diretamente.

Objetivo: Reduzir o acoplamento e facilitar a testabilidade.
Exemplo de problema: Substituir serviços em testes unitários (ex.: substituir um banco de dados real por um mock).

```java
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository repository) { this.userRepository = repository; }
}
```

## Factory Method
Um padrão de criação que define um método para criar objetos, permitindo que subclasses alterem o tipo de objeto que será criado.

Objetivo: Delegar a responsabilidade de criação às subclasses.
Exemplo de problema: Criar diferentes tipos de documentos como PDFs, Word, ou Excel.

```java
public abstract class DocumentFactory {
    public abstract Document createDocument();
}
public class PdfFactory extends DocumentFactory {
    public Document createDocument() { return new PdfDocument(); }
}
```

## Observer

Um padrão comportamental que define uma relação de dependência entre objetos, permitindo que um objeto notifique outros automaticamente quando seu estado muda.

Objetivo: Implementar comunicação eficiente entre objetos desacoplados.
Exemplo de problema: Atualizar automaticamente interfaces gráficas quando dados de backend mudam.

```java
public interface Observer { void update(String message); }
public class EmailSubscriber implements Observer {
    public void update(String message) { System.out.println("Email received: " + message); }
}
public class NewsPublisher {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer) { observers.add(observer); }
    public void notifyObservers(String message) {
        for (Observer observer : observers) { observer.update(message); }
    }
}
```

## Proxy

Um padrão estrutural que fornece um substituto ou representante para outro objeto para controlar o acesso a ele.

Objetivo: Adicionar uma camada de controle ou otimização para acessar recursos custosos.
Exemplo de problema: Controlar acesso a um objeto remoto ou proteger um recurso sensível.

```java
public interface Image { void display(); }
public class RealImage implements Image {
    public RealImage(String fileName) { System.out.println("Loading " + fileName); }
    public void display() { System.out.println("Displaying image"); }
}
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;
    public ProxyImage(String fileName) { this.fileName = fileName; }
    public void display() {
        if (realImage == null) { realImage = new RealImage(fileName); }
        realImage.display();
    }
}
```

## Strategy

Um padrão comportamental que permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis.

Objetivo: Trocar algoritmos dinamicamente sem alterar o código cliente.
Exemplo de problema: Implementar diferentes estratégias de cálculo de frete (por peso, por distância, etc.).

```java
public interface ShippingStrategy {
    double calculate(double weight, double distance);
}
public class AirShipping implements ShippingStrategy {
    public double calculate(double weight, double distance) { return weight *distance* 0.5; }
}
public class GroundShipping implements ShippingStrategy {
    public double calculate(double weight, double distance) { return weight *distance* 0.2; }
}
```
