# YESTERDAYSNEWS API Documentation

Esta documentación describe los endpoints disponibles en la API de **Yesterdaysnews**, incluyendo las entidades, métodos, y ejemplos de solicitudes y respuestas.

---

## **Entidad: User**

### **1. Crear un usuario**

- **Método**: `POST`
- **Endpoint**: `http://localhost:8080/api/v1/users`
- **Descripción**: Crea un nuevo usuario en el sistema.

#### **Request Body**:

```json
{
  "username": "exampleUser",
  "emailAddress": "example@example.com"
}
```
