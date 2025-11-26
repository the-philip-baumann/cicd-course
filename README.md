### Projekt builden
`mvn clean install`\
`mvn clean install -DskipTests`

### Build scheitern lassen
`@Disabled` in der Klasse `FictitiousTest` enterfnen und der Test sollte failen.

## Kurzes Guide zu Github-Actions
Github-Actions ermöglicht es euch einfach Pipelines zu erstellen. Wir wollen Github-Actions verwenden, um eine triviale CI/CD Pipeline zu schaffen.
Eine solche Pipeline könnt ihr über die Oberläche von Github anlegen. Anschliessend müsst ihr im *.yml-File konfigurativ die Pipeline definieren.

### On Push
Diese Konfiguration definiert, wann ein Pipeline-Run gestartet werden soll. Versuche den die Koniguration zu verstehen.
```
on:
  push:
    branches:
      - '**'
```

Ein Job umfasst von uns definierte Steps (`build`, `test`, `deploy`) und definiert zugleich auf welcher Umgebung der Pipeline-Run laufen soll. 
In unserem Fall wärde das die aktuellste Version von Ubuntu `runs-on: ubuntu-latest`
```
jobs:
    runs-on: ubuntu-latest
    
    steps:
        build:
            ...
        test:
            ...
        deploy:
            ...
```

Ein Step besteht aus ein oder mehreren Anweisungen. Eine solche Anweisung startet mit einem `-name: Name der Anweisung` und auf der folgenden Zeile kommt dann die Anweisung. In diesem Fall `run: Befehl`.
Der `Befehl` kann irgend eine Anweisung auf der Kommandozeile (Ubuntu CLI) sein.

```
jobs:
    runs-on: ubuntu-latest
    
    steps:
        stepName:
          - name: Build (Maven)
            run: echo 'Hello World.'
```

Im Step `build` sollt ihr nun versuchen den Branch, welcher den Pipeline-Run getriggert hat auszuchecken. Anschliessend den aktuellen Stand des Master-Branches in euren Branch hineinziehen und abschliessend einen Maven-Build durchführen (Achtung: Ihr müsst wohl zuerst noch sicherstellen, dass der Pipeline-Run über die JDK-17 verfügt).

### Workflow permissions
Damit das ganze auch funktioniert, müsst ihr Github-Actions die nötigen Berechtigungen auf eurem Github-Repo vergeben.


