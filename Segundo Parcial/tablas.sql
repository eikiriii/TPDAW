-- 1. Tabla de Usuarios
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    correo VARCHAR(100) UNIQUE,
    contraseña VARCHAR(100)
);

-- 2. Tabla de Productos
CREATE TABLE productos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    precio DECIMAL(10,2),
    stock INT
);

-- 3. Tabla de Órdenes
CREATE TABLE ordenes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT,
    fecha DATE,
    total DECIMAL(10,2),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

-- 4. Tabla de Detalles de Orden
CREATE TABLE detalle_orden (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_orden INT,
    id_producto INT,
    cantidad INT,
    FOREIGN KEY (id_orden) REFERENCES ordenes(id),
    FOREIGN KEY (id_producto) REFERENCES productos(id)
);

-- 5. Tabla de Estudiantes
CREATE TABLE estudiantes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    carrera VARCHAR(100),
    semestre INT
);

-- 6. Tabla de Profesores
CREATE TABLE profesores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    especialidad VARCHAR(100)
);

-- 7. Tabla de Cursos
CREATE TABLE cursos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    id_profesor INT,
    FOREIGN KEY (id_profesor) REFERENCES profesores(id)
);

-- 8. Tabla de Inscripciones
CREATE TABLE inscripciones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_estudiante INT,
    id_curso INT,
    calificacion DECIMAL(3,1),
    FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id),
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
);

-- 9. Tabla de Planetas
CREATE TABLE planetas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    diametro_km INT,
    distancia_sol_millones_km DECIMAL(10,2),
    tiene_anillos BOOLEAN
);

-- 10. Tabla de Empleados
CREATE TABLE empleados (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    puesto VARCHAR(50),
    salario DECIMAL(10,2)
);

-- 11. Tabla de Departamentos
CREATE TABLE departamentos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    ubicacion VARCHAR(100)
);

-- 12. Tabla de Pacientes
CREATE TABLE pacientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    edad INT,
    genero ENUM('M', 'F')
);

-- 13. Tabla de Citas Médicas
CREATE TABLE citas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_paciente INT,
    fecha DATETIME,
    motivo TEXT,
    FOREIGN KEY (id_paciente) REFERENCES pacientes(id)
);

-- 14. Tabla de Vehículos
CREATE TABLE vehiculos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    año INT
);

-- 15. Tabla de Servicios (taller)
CREATE TABLE servicios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(100),
    costo DECIMAL(8,2)
);

-- 16. Tabla de Reservaciones (hotel)
CREATE TABLE reservaciones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_cliente VARCHAR(100),
    fecha_entrada DATE,
    fecha_salida DATE
);

-- 17. Tabla de Habitaciones
CREATE TABLE habitaciones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(50),
    precio_noche DECIMAL(10,2),
    disponible BOOLEAN
);

-- 18. Tabla de Comentarios
CREATE TABLE comentarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT,
    contenido TEXT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

-- 19. Tabla de Categorías
CREATE TABLE categorias (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50)
);

-- 20. Tabla de Publicaciones (blog)
CREATE TABLE publicaciones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100),
    contenido TEXT,
    id_categoria INT,
    fecha_publicacion DATE,
    FOREIGN KEY (id_categoria) REFERENCES categorias(id)
);

-- 21. Tabla de Envios
CREATE TABLE envios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    destinatario VARCHAR(100),
    direccion VARCHAR(200),
    fecha_envio DATE,
    estatus ENUM('pendiente', 'en tránsito', 'entregado')
);

-- 22. Tabla de Facturas
CREATE TABLE facturas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cliente VARCHAR(100),
    fecha DATE,
    total DECIMAL(10,2),
    pagada BOOLEAN
);

-- 23. Tabla de Proveedores
CREATE TABLE proveedores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    email VARCHAR(100)
);

-- 24. Tabla de Inventario
CREATE TABLE inventario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    producto VARCHAR(100),
    cantidad INT,
    ubicacion VARCHAR(50)
);

-- 25. Tabla de Libros
CREATE TABLE libros (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(150),
    autor VARCHAR(100),
    isbn VARCHAR(20),
    disponible BOOLEAN
);

-- 26. Tabla de Préstamos de Libros
CREATE TABLE prestamos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_libro INT,
    nombre_usuario VARCHAR(100),
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    FOREIGN KEY (id_libro) REFERENCES libros(id)
);

-- 27. Tabla de Transporte Público
CREATE TABLE transporte (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo ENUM('autobús', 'metro', 'tranvía'),
    ruta VARCHAR(50),
    capacidad INT
);

-- 28. Tabla de Comentarios en Red Social
CREATE TABLE comentarios_social (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(100),
    comentario TEXT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 29. Tabla de Transacciones Bancarias
CREATE TABLE transacciones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cuenta VARCHAR(20),
    tipo ENUM('depósito', 'retiro', 'transferencia'),
    monto DECIMAL(10,2),
    fecha DATE
);

-- 30. Tabla de Encuestas
CREATE TABLE encuestas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(150),
    descripcion TEXT,
    fecha_inicio DATE,
    fecha_fin DATE
);