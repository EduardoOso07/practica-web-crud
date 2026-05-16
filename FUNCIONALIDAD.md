
# QUÉ HACE LA APLICACIÓN - AGENDA DE CONTACTOS

## Descripción general

La aplicación es un CRUD (Create, Read, Update, Delete) completo para gestionar una agenda de contactos. Permite a los usuarios registrar, visualizar, modificar y eliminar contactos a través de una interfaz web.

## Funcionalidades principales

### 1. CREAR contacto (Guardar)
El usuario ingresa los datos de un nuevo contacto:
- Nombre (obligatorio)
- Teléfono (opcional)
- Dirección (opcional)
- Email (obligatorio)

Al hacer clic en "Guardar Contacto", los datos se almacenan en MySQL.

### 2. READ (Listar contactos)
La página principal muestra automáticamente todos los contactos guardados en una tabla con:
- ID, Nombre, Teléfono, Dirección, Email
- Botones Editar y Eliminar por cada contacto

### 3. UPDATE (Editar contacto)
Al hacer clic en "Editar":
- Se abre formulario con los datos del contacto
- El usuario modifica los campos
- Al guardar, la base de datos se actualiza

### 4. DELETE (Eliminar contacto)
Al hacer clic en "Eliminar":
- Aparece cuadro de confirmación
- Si confirma, el contacto se borra de MySQL
```text
MODELO (Contacto.java + ContactoDAO.java)
↓
MySQL
↓
VISTA (index.jsp + editar.jsp)
↓
CONTROLADOR (AddContacto.java - Servlet)
```

## Flujo de datos

### Guardar un contacto:
1. Usuario completa formulario en index.jsp
2. Formulario envía datos a AddContacto (POST)
3. Servlet recibe parámetros (nom, tel, dir, mail)
4. Crea objeto Contacto
5. Llama a ContactoDAO.insertar()
6. DAO ejecuta INSERT en MySQL
7. Servlet redirige a index.jsp con mensaje de éxito

### Listar contactos:
1. Usuario abre index.jsp
2. JSP ejecuta ContactoDAO.listar()
3. DAO consulta MySQL: SELECT * FROM contactos
4. Retorna lista de objetos Contacto
5. JSP genera tabla HTML con los datos

## Interfaz de usuario

### Pantalla principal (index.jsp)
- Título "Agenda de Contactos"
- Formulario para nuevo contacto
- Tabla con todos los contactos
- Botones Editar y Eliminar por fila

### Pantalla de edición (editar.jsp)
- Título "Editar Contacto"
- Formulario precargado con datos del contacto
- Botón "Actualizar Contacto"
- Enlace "Cancelar"

## Mensajes de retroalimentación

| Acción | Mensaje |
|--------|---------|
| Guardar éxito | ✅ Contacto guardado con éxito |
| Actualizar éxito | ✅ Contacto actualizado con éxito |
| Eliminar éxito | ✅ Contacto eliminado con éxito |
| Error | ❌ Error en la operación |

## Seguridad implementada

- Prevención de SQL Injection: Uso de PreparedStatement
- Validación básica: Campos nombre y email obligatorios
- Confirmación de eliminación: JavaScript
- Sanitización de caracteres: escapeHtml()
