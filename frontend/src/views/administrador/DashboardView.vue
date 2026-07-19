<template>
  <div class="dashboard-wrapper">
    <nav class="nav">
      <div class="nav-container">
        <router-link to="/dashboard" class="nav-figure">
          <img src="../../imagenes/logo.png" class="nav-logo" alt="Logo Cronos" />
        </router-link>
        
        <label class="nav-toggle" for="menu-input">
          <input type="checkbox" id="menu-input" class="nav-input" />
        </label>

        <ul class="nav-list">
          <li class="nav-item"><router-link :to="{ name: 'perfil-admin' }" class="nav-link">Perfil</router-link></li>
        </ul>
      </div>
    </nav>

    <main class="dashboard-main">
      <div class="dashboard-header">
        <h1>Panel de Control</h1>
        <p>Bienvenido al sistema de gestión académica</p>
      </div>

      <div class="dashboard-grid">
        <!-- SECCIÓN: Gestión de Personas -->
        <router-link to="./alumnos" class="dashboard-card">
          <div class="card-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
              <circle cx="9" cy="7" r="4"></circle>
              <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
              <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
            </svg>
          </div>
          <h3>Alumnos</h3>
          <p>Gestión de estudiantes</p>
          <span class="card-arrow">→</span>
        </router-link>

        <router-link to="./profesores" class="dashboard-card">
          <div class="card-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
              <circle cx="12" cy="7" r="4"></circle>
              <polyline points="16 11 18 13 22 9"></polyline>
            </svg>
          </div>
          <h3>Profesores</h3>
          <p>Personal docente</p>
          <span class="card-arrow">→</span>
        </router-link>

        <!-- SECCIÓN: Configuración Académica -->
        <router-link to="./materias" class="dashboard-card">
          <div class="card-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <path d="M4 19.5A2.5 2.5 0 0 1 6.5 17H20"></path>
              <path d="M6.5 2H20v20H6.5A2.5 2.5 0 0 1 4 19.5v-15A2.5 2.5 0 0 1 6.5 2z"></path>
            </svg>
          </div>
          <h3>Materias</h3>
          <p>Asignaturas</p>
          <span class="card-arrow">→</span>
        </router-link>

        <router-link to="./divisiones" class="dashboard-card">
          <div class="card-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <rect x="2" y="7" width="20" height="14" rx="2" ry="2"></rect>
              <path d="M16 21V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16"></path>
            </svg>
          </div>
          <h3>Divisiones</h3>
          <p>Organización académica</p>
          <span class="card-arrow">→</span>
        </router-link>

        <router-link to="./grupos" class="dashboard-card">
          <div class="card-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
              <circle cx="9" cy="7" r="4"></circle>
              <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
              <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
            </svg>
          </div>
          <h3>Grupos</h3>
          <p>Clases y secciones</p>
          <span class="card-arrow">→</span>
        </router-link>

        <!-- SECCIÓN: Infraestructura -->
        <router-link to="./edificios" class="dashboard-card">
          <div class="card-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <rect x="4" y="2" width="16" height="20" rx="2" ry="2"></rect>
              <line x1="9" y1="22" x2="9" y2="2"></line>
              <line x1="15" y1="22" x2="15" y2="2"></line>
              <line x1="4" y1="6" x2="20" y2="6"></line>
              <line x1="4" y1="10" x2="20" y2="10"></line>
              <line x1="4" y1="14" x2="20" y2="14"></line>
              <line x1="4" y1="18" x2="20" y2="18"></line>
            </svg>
          </div>
          <h3>Edificios</h3>
          <p>Infraestructura</p>
          <span class="card-arrow">→</span>
        </router-link>

        <router-link to="./aulas" class="dashboard-card">
          <div class="card-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
              <polyline points="9 22 9 12 15 12 15 22"></polyline>
            </svg>
          </div>
          <h3>Aulas</h3>
          <p>Salones disponibles</p>
          <span class="card-arrow">→</span>
        </router-link>

        <!-- SECCIÓN: Configuración Temporal -->
        <router-link to="./periodo" class="dashboard-card">
          <div class="card-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect>
              <line x1="16" y1="2" x2="16" y2="6"></line>
              <line x1="8" y1="2" x2="8" y2="6"></line>
              <line x1="3" y1="10" x2="21" y2="10"></line>
            </svg>
          </div>
          <h3>Periodos</h3>
          <p>Ciclos escolares</p>
          <span class="card-arrow">→</span>
        </router-link>

        <router-link to="./turno" class="dashboard-card">
          <div class="card-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <circle cx="12" cy="12" r="10"></circle>
              <polyline points="12 6 12 12 16 14"></polyline>
            </svg>
          </div>
          <h3>Turnos</h3>
          <p>Horarios generales</p>
          <span class="card-arrow">→</span>
        </router-link>

        <!-- SECCIÓN: Asignaciones -->
        <router-link to="./profesoresasignaturas" class="dashboard-card">
          <div class="card-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor"stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <path d="M16 21v-2a4 4 0 0 0-4-4H6a4 4 0 0 0-4 4v2"></path>
              <circle cx="9" cy="7" r="4"></circle>
              <polyline points="16 11 18 13 22 9"></polyline>
            </svg>
          </div>
          <h3>Asignación de Profesores</h3>
          <p>Grupos y asignaturas a profesores</p>
          <span class="card-arrow">→</span>
        </router-link>

        <!-- SECCIÓN: Horarios -->
        <router-link to="./horarios" class="dashboard-card">
          <div class="card-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect>
              <line x1="3" y1="10" x2="21" y2="10"></line>
              <line x1="9" y1="22" x2="9" y2="10"></line>
              <line x1="15" y1="22" x2="15" y2="10"></line>
            </svg>
          </div>
          <h3>Horarios</h3>
          <p>Programación de clases</p>
          <span class="card-arrow">→</span>
        </router-link>
      </div>
    </main>
  </div>
</template>

<script setup>
import '../../assets/styles.css'
</script>

<style scoped>
/* =======================
   DASHBOARD - ESTILO CONSISTENTE
======================= */

.dashboard-wrapper {
  min-height: 100vh;
}

.dashboard-main {
  max-width: 1400px;
  margin: 0 auto;
  padding: 30px 20px;
}

.dashboard-header {
  text-align: center;
  margin-bottom: 40px;
}

.dashboard-header h1 {
  font-size: 2rem;
  color: #2c3e50;
  margin-bottom: 8px;
}

.dashboard-header p {
  color: #7f8c8d;
  font-size: 1rem;
}

/* Grid de tarjetas */
.dashboard-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 24px;
}

/* Tarjeta individual */
.dashboard-card {
  background: white;
  border-radius: 16px;
  padding: 24px;
  text-decoration: none;
  transition: all 0.3s ease;
  border: 1px solid #eef2f6;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.04);
  position: relative;
  overflow: hidden;
  display: block;
}

.dashboard-card:hover {
  transform: translateY(-4px);
  box-shadow: 0 12px 24px rgba(0, 0, 0, 0.1);
  border-color: #3abef9;
}

/* Icono */
.card-icon {
  width: 48px;
  height: 48px;
  background: #f0f7ff;
  border-radius: 12px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 20px;
  transition: all 0.3s ease;
}

.card-icon svg {
  width: 24px;
  height: 24px;
  color: #3abef9;
  stroke: #3abef9;
}

.dashboard-card:hover .card-icon {
  background: #3abef9;
}

.dashboard-card:hover .card-icon svg {
  stroke: white;
}

/* Títulos */
.dashboard-card h3 {
  font-size: 1.25rem;
  font-weight: 700;
  color: #1e293b;
  margin: 0 0 8px 0;
}

.dashboard-card p {
  font-size: 0.85rem;
  color: #64748b;
  margin: 0;
  line-height: 1.4;
}

/* Flecha */
.card-arrow {
  position: absolute;
  bottom: 20px;
  right: 20px;
  font-size: 1.25rem;
  color: #cbd5e1;
  transition: all 0.3s ease;
  opacity: 0;
  transform: translateX(-8px);
}

.dashboard-card:hover .card-arrow {
  opacity: 1;
  transform: translateX(0);
  color: #3abef9;
}

/* Responsive */
@media (max-width: 768px) {
  .dashboard-main {
    padding: 20px 15px;
  }
  
  .dashboard-header h1 {
    font-size: 1.5rem;
  }
  
  .dashboard-grid {
    gap: 16px;
  }
  
  .dashboard-card {
    padding: 20px;
  }
  
  .card-icon {
    width: 40px;
    height: 40px;
    margin-bottom: 16px;
  }
  
  .card-icon svg {
    width: 20px;
    height: 20px;
  }
  
  .dashboard-card h3 {
    font-size: 1.1rem;
  }
}
</style>