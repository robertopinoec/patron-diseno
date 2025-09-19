# Biblioteca (Spring Boot 3.5.5, Java 21, H2)

## Ejecutar
```bash
mvn spring-boot:run
```
API de verificación rápida:
- `GET /api/libros` listar
- `POST /api/libros` agregar
- `GET /api/libros/buscar?tipo=autor&valor=Torres` buscar por autor (Strategy)
- `POST /api/libros/{id}/prestar` prestar (Decorator + Observer + auditoría JDBC)

La consola H2 estará disponible en `/h2-console` (JDBC URL `jdbc:h2:mem:biblioteca`).
