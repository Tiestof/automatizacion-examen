# Automatización de Pruebas – Examen Final

Este repositorio contiene el proyecto **automatizacion-examen**, desarrollado para el examen de la asignatura **Automatización de Pruebas**.

El proyecto está construido con **Java 17** y **Maven**, e incluye una estrategia de pruebas automatizadas integrada con **GitHub Actions**, 
cubriendo tanto **Integración Continua (CI)** como **Despliegue Continuo (CD)**.

---

## 1. Descripción del proyecto

El proyecto define una clase principal simple (`App`) y un conjunto de pruebas automatizadas que permiten demostrar:

- Uso de **Maven** como gestor de dependencias y herramienta de build.
- Ejecución de distintos **niveles de pruebas**:
  - Pruebas unitarias.
  - Pruebas de integración.
  - Pruebas de aceptación (acceptance tests).
    
- Configuración de **pipelines CI/CD**:
  - Pipeline de **Integración Continua** (build + pruebas).
  - Pipeline de **Despliegue** a ambiente de pruebas con **rollback** automático.

El foco no está en la lógica de negocio, sino en la correcta implementación de la **estrategia de pruebas y automatización de pipelines**.

---

## 2. Estrategia de pruebas implementada

Las pruebas se organizan bajo `src/test/java` de la siguiente forma:

- **Pruebas unitarias**  
  Carpeta: `src/test/java/cl/iplacex/automatizacion/unit`  
  - Ejemplo: `AppUnitTest.java`  
  Validan funcionalidades aisladas de la clase `App`.

- **Pruebas de integración**  
  Carpeta: `src/test/java/cl/iplacex/automatizacion/integracion`  
  - Ejemplo: `AppIntegrationTest.java`  
  Simulan un flujo que integra varios pasos de la lógica (p. ej. sumas encadenadas).

- **Pruebas de aceptación (acceptance tests)**  
  Carpeta: `src/test/java/cl/iplacex/automatizacion/acceptance`  
  - Ejemplo: `AppAcceptanceTest.java`  
  Representan escenarios completos desde el punto de vista del usuario/negocio.

Todas las pruebas están implementadas con **JUnit 5**, utilizando el plugin **maven-surefire** para su ejecución automática.

---

## 3. Cómo ejecutar las pruebas localmente

### 3.1. Requisitos

- Java 17 instalado (`java -version`)
- Maven 3.9.x o superior (`mvn -version`)

### 3.2. Ejecutar todas las pruebas

Desde la carpeta raíz del proyecto (donde está el `pom.xml`):

### 3.3. Ejecutar solo pruebas unitarias
mvn -Dtest=*UnitTest test

### 3.4. Ejecutar solo pruebas de integración
mvn -Dtest=*IntegrationTest test

### 3.5. Ejecutar solo pruebas de aceptación
mvn -Dtest=*AcceptanceTest test

---
## 4. Pipelines de CI/CD

El repositorio define dos pipelines en GitHub Actions, ubicados en:

./github/workflows/ci-maven.yml → Pipeline de Integración Continua

./github/workflows/deploy.yml → Pipeline de Despliegue (CD)

### 4.1. Pipeline de CI – ci-maven.yml

Este pipeline se ejecuta en los siguientes eventos:
push sobre main y ramas feature/*
pull_request hacia main

Stages principales:

Build
Ejecuta mvn clean compile para verificar que el proyecto compila correctamente.
Pruebas unitarias
Ejecuta las pruebas ubicadas en unit.
Pruebas de integración
Ejecuta las pruebas ubicadas en integracion.

### 4.2. Pipeline de CD – deploy.yml

Este pipeline representa el deployment pipeline del examen e incluye:

Trigger:

push sobre main y feature/deployment-pipeline
Ejecución manual con workflow_dispatch desde la pestaña Actions.

Jobs / Stages:

build
Ejecuta mvn clean package.
acceptance-tests
Ejecuta las pruebas de aceptación (*AcceptanceTest).
deploy-to-test
Simula el despliegue en un ambiente de pruebas, registrando la versión en deployed_version.txt.
rollback

Se ejecuta automáticamente si algún stage previo falla (if: failure()), simulando el rollback a una versión anterior.

---

## 5. Cómo ejecutar los pipelines en GitHub Actions
### 5.1. Pipeline de CI (ci-maven.yml)

Se ejecuta automáticamente al:

Hacer push a main o a una rama feature/*.
Crear un Pull Request hacia main.

Pasos para revisar la ejecución:

Ir a la pestaña Actions del repositorio.
Seleccionar el workflow “CI Maven - Automatización de Pruebas”.

Abrir la última ejecución para ver:

Stage de build.
Pruebas unitarias.
Pruebas de integración.

### 5.2. Pipeline de CD (deploy.yml)

Opción A: Trigger automático
Hacer push a main o feature/deployment-pipeline.

Opción B: Ejecutarlo manualmente
Pestaña Actions.

Seleccionar el workflow “CD - Deployment Pipeline”.
Pulsar “Run workflow”, elegir la rama y confirmar.

En la ejecución se pueden observar los stages:

build
acceptance-tests
deploy-to-test
rollback (solo si se provoca un fallo en las pruebas)

---

6. Evidencias de funcionamiento

En la carpeta docs/ (o en este mismo README) se incluyen capturas de pantalla que evidencian el correcto funcionamiento de los pipelines:

CI – Build + Pruebas


Figura 1: Ejecución exitosa del pipeline de CI con build y pruebas unitarias/integración.

CD – Deploy en ambiente de pruebas
<img width="921" height="368" alt="image" src="https://github.com/user-attachments/assets/280ed07b-d1fb-4133-b6dd-1a25c622db84" />

TEST Unitario
<img width="921" height="318" alt="image" src="https://github.com/user-attachments/assets/4695a194-fde2-4449-b4e2-72bde5994bda" />

TEST Integración
<img width="921" height="318" alt="image" src="https://github.com/user-attachments/assets/a78bd710-1d40-4c4e-a2fc-0711ae184c1d" />


Figura 2: Despliegue simulado en ambiente de pruebas mostrando la versión desplegada.

Evidencia del build
<img width="921" height="244" alt="image" src="https://github.com/user-attachments/assets/6d4bd55c-db42-4948-9665-e0a33b2676af" />

Ejecución de rollback

Figura 3: Activación del job de rollback luego de un fallo en las pruebas de aceptación.
<img width="921" height="472" alt="image" src="https://github.com/user-attachments/assets/5e43796f-ae2e-41ce-a0a8-3c4d9be37d46" />

Ejecución correcta del pipeline
<img width="921" height="505" alt="image" src="https://github.com/user-attachments/assets/c87c9a74-20b0-4d28-87ee-d253aff8918e" />

Evidencia de Branches
<img width="1637" height="790" alt="image" src="https://github.com/user-attachments/assets/c1dbf4a9-168d-4a84-bc2a-fe55475c500d" />



Nota: las imágenes deben agregarse al repositorio en la ruta indicada (/docs) o actualizar las rutas de las imágenes según la ubicación que se utilice.

---

## 7. Notas finales

Este proyecto está orientado a demostrar:
Uso de control de versiones con Git y flujo basado en ramas (main, feature/*).
Configuración de un proyecto Maven de pruebas automatizadas.
Implementación de pipelines CI/CD con distintos niveles de pruebas.
Simulación de despliegue en ambiente de pruebas y mecanismo de rollback.
Cualquier cambio o extensión (nuevas pruebas, nuevos stages) debe mantener la estructura y convenciones definidas en este README.


```bash
mvn test


