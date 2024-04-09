-- ----------------------------------------------------------------------------------------------------------------------------------------------------
-- 														B A S E   D E   D A T O S
-- ----------------------------------------------------------------------------------------------------------------------------------------------------
CREATE DATABASE laboratorios_solfran;
USE laboratorios_solfran;

-- Creación de la tabla usuarios
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    correo VARCHAR(100),
    contrasena VARCHAR(255),
    rol VARCHAR(20)
);

select * from usuarios;
insert into usuarios (nombre, apellido, correo, contrasena, rol) values ('Yuriana', 'Ibarra', 'yuriana@gmail.com', 'Yuriana04', 'Laboratorista');
select id_usuario from usuarios where nombre = 'Yuriana' and apellido = 'Ibarra';
select contrasena from usuarios where nombre = 'Yuriana' and apellido = 'Ibarra';
select id_usuario from usuarios where nombre = 'Yuriana' and apellido = 'Ibarra' and contrasena = 'Yuriana04';

-- Creación de la tabla accesos_remotos
CREATE TABLE accesos_remotos (
    id_acceso INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    fecha_solicitud DATETIME,
    autorizado BOOLEAN,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

select * from accesos_remotos;
insert into accesos_remotos (id_usuario, fecha_solicitud, autorizado) values (1, NOW(), 1);
insert into accesos_remotos (id_usuario, fecha_solicitud, autorizado) values (1, '2024-04-08 14:47:30', 0);
insert into accesos_remotos (id_usuario, fecha_solicitud, autorizado) values (1, '2024-04-08 16:47:30', true);

-- Creación de la tabla datos_muestras
CREATE TABLE datos_muestras (
    id_muestra INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    fecha_ingreso DATETIME,
    datos TEXT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

select * from datos_muestras;
insert into datos_muestras (id_usuario, fecha_ingreso, datos) values (1, '2023-11-15 10:20:00', 'Análisis de laboratorio sobre la composición química y la estabilidad de un nuevo fármaco diseñado para tratar la hipertensión arterial.');
insert into datos_muestras (id_usuario, fecha_ingreso, datos) values (1, '2024-03-22 15:45:00', 'Resultados de pruebas de calidad realizadas en lotes de productos farmacéuticos para verificar su conformidad con los estándares regulatorios.');
select id_muestra from datos_muestras where id_usuario = 1 and date(fecha_ingreso) = '2024-03-22';

-- Creación de la tabla pruebas_calidad
CREATE TABLE pruebas_calidad (
    id_prueba INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_muestra INT,
    resultado TEXT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_muestra) REFERENCES datos_muestras(id_muestra)
);

select * from pruebas_calidad;
insert into pruebas_calidad (id_usuario, id_muestra, resultado) values (2, 1, 'Aceptada');
insert into pruebas_calidad (id_usuario, id_muestra, resultado) values (2, 2, 'Rechazada');

-- Creación de la tabla control_inventario
CREATE TABLE control_inventario (
    id_inventario INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    fecha_registro DATETIME,
    datos TEXT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

select * from control_inventario;
insert into control_inventario (id_usuario, fecha_registro, datos) values (1, '2024-03-24 10:30:00', 'Actualización del inventario de medicamentos: se agregaron 100 unidades de ibuprofeno y se retiraron 50 unidades de paracetamol.');
insert into control_inventario (id_usuario, fecha_registro, datos) values (2, '2024-03-25 14:15:00', 'Inventario de vacunas actualizado: se agregaron 50 dosis de vacuna contra la gripe y se retiraron 20 dosis de vacuna contra el sarampión.');

-- Creación de la tabla monitoreo_produccion_distribucion
CREATE TABLE monitoreo_produccion_distribucion (
    id_monitoreo INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    fecha_monitoreo DATETIME,
    datos TEXT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

select * from monitoreo_produccion_distribucion;
insert into monitoreo_produccion_distribucion (id_usuario, fecha_monitoreo, datos) values (2, '2024-03-26 08:45:00', 'Informe de monitoreo de producción: se registró un aumento del 10% en la producción de tabletas de vitamina C en comparación con la semana anterior.');
insert into monitoreo_produccion_distribucion (id_usuario, fecha_monitoreo, datos) values (1, '2024-03-27 11:20:00', 'Informe de distribución de productos: se completó la entrega de medicamentos a todas las farmacias afiliadas en la región metropolitana.');

-- Creación de la tabla auditorias
CREATE TABLE auditorias (
    id_auditoria INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    fecha_auditoria DATETIME,
    datos_consultados TEXT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

select * from auditorias;
insert into auditorias (id_usuario, fecha_auditoria, datos_consultados) 
values 
    (1, '2024-03-28 09:30:00', 'Se consultaron los registros de producción del último trimestre.'),
    (2, '2024-03-27 15:45:00', 'Se realizaron consultas sobre el cumplimiento de normativas sanitarias en el proceso de distribución de medicamentos.');

-- Creación de la tabla verificacion_cumplimiento_normativo
CREATE TABLE verificacion_cumplimiento_normativo (
    id_verificacion INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    fecha_verificacion DATETIME,
    datos_verificados TEXT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Creación de la tabla automatizacion_procesos_clave
CREATE TABLE automatizacion_procesos_clave (
    id_automatizacion INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    fecha_automatizacion DATETIME,
    datos_automatizados TEXT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Consultas
EXPLAIN SELECT * FROM pruebas_calidad WHERE resultado = 'Aceptable';

CREATE INDEX idx_resultado ON pruebas_calidad(resultado);

SELECT u.nombre, p.resultado 
FROM usuarios u 
JOIN pruebas_calidad p ON u.id_usuario = p.id_usuario 
WHERE u.rol = 'operador_lab';

CREATE TABLE cache_consultas (
    id_consulta INT PRIMARY KEY,
    resultado TEXT
);

SELECT * FROM performance_schema.events_statements_summary_by_digest;

ALTER TABLE datos_muestras ROW_FORMAT=COMPRESSED;

-- Creación de roles y asignación de permisos
CREATE ROLE administrador;
CREATE ROLE operador_laboratorio;
CREATE ROLE auditor;

-- Concesión de privilegios a cada rol
GRANT ALL PRIVILEGES ON laboratorios_solfran.* TO administrador;
GRANT SELECT, INSERT, UPDATE, DELETE ON laboratorios_solfran.* TO operador_laboratorio;
GRANT SELECT ON laboratorios_solfran.* TO auditor;

-- Creación de usuarios y asignación de roles
CREATE USER 'admin_lab' IDENTIFIED BY 'AdminLab2023!';
CREATE USER 'operador_lab' IDENTIFIED BY 'Operador1234!';
CREATE USER 'auditor_lab' IDENTIFIED BY 'Auditor5678!';

GRANT administrador TO 'admin_lab';
GRANT operador_laboratorio TO 'operador_lab';
GRANT auditor TO 'auditor_lab';

-- Crear una tabla para almacenar datos sensibles
CREATE TABLE datos_sensibles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    datos_encriptados VARCHAR(255)
);

-- Insertar datos en la tabla
INSERT INTO datos_sensibles (nombre, datos_encriptados)
VALUES ('Ejemplo', ENCRYPT('Información sensible', 'datos_encript_clave'));

-- Seleccionar datos desencriptados
SELECT nombre, DECRYPT(datos_encriptados, 'datos_encript_clave') AS datos_desencriptados
FROM datos_sensibles;