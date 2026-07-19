# 1. Usamos una imagen oficial de Python ligera
FROM python:3.11-slim

# 2. Establecemos el directorio de trabajo en el contenedor
WORKDIR /app

# 3. Copiamos el archivo de dependencias (si usas librerías como Flask, FastAPI, etc.)
COPY requirements.txt .

# 4. Instalamos las dependencias
RUN pip install --no-cache-dir -r requirements.txt

# 5. Copiamos todo el código del algoritmo de Python a la imagen
COPY . .

# 6. Exponemos el puerto en el que va a correr tu API de Python (ej. 5000)
EXPOSE 5000

# 7. Comando para arrancar tu script principal
CMD ["python", "main.py"]