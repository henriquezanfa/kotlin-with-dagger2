## Kotlin com Dagger 2

O objetivo desse projeto é adicionar dagger 2 e, consequentemente, injeção de dependência a um aplicativo pré-existente.

A execução foi baseada nesse [tutorial](https://www.raywenderlich.com/262-dependency-injection-in-android-with-dagger-2-and-kotlin).

### Inicialicação Básica

Os passos a seguir são os primeiros passos para habilitar o dagger 2 em sua aplicação.

1. Adicionar as dependências do Dagger 2 ao build.gradle
```implementation 'com.google.dagger:dagger:$DAGGER_VERSION'```

2. Criar um ```Módulo da Aplicação```, responsável por prover as dependências as partes necessárias do app.
```
@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = app
}
```

3. Criar um ```Componente da Aplicação```, responsável por conectar os objetos e suas dependências
```
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent
```

4. Adicionar o ```AppComponent``` à aplicação
```
class MyApp : Application() {
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = initDagger(this)
    }

    private fun initDagger(app: MyApp): AppComponent =
            DaggerAppComponent.builder().appModule(AppModule(app)).build()
}
```

### Processo Geral

Os passos a seguir são os responsáveis pela injeção de uma classe qualquer após previamente configurar o dagger (descito no tópico anterior)


1. Criar um ```Método de injeção``` no Componente da Aplicação com a classe a ser injetada como argumento
``` 
    fun inject(target: MyClass)
```

2. Adicionar um método anotado com ```@Provides``` no módulo para cada objeto a ser injetado
```
@Module
class MyClassModule {
    @Singleton
    @Provides
    fun provideSomeClass(myClass: MyClass): ProvidedClass = ProvidedClassImp(myClass)
}
```

3. Adicionar ```@Inject``` para cada membro injetado na classe target
```
  @Inject lateinit var providedClass: ProvidedClass
```

4. Inicializar a injeção na classe target
```
class MyClass : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApp).component.inject(this)
    }
}
```
