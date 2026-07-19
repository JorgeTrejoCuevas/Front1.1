<template>
  <div v-if="showLanding" class="landing-wrapper animate-bg">
    <!-- Formas decorativas (como el login) -->
    <div class="bg-shapes">
      <div class="shape shape-1"></div>
      <div class="shape shape-2"></div>
      <div class="shape shape-3"></div>
    </div>

    <!-- NAVBAR FLOTANTE (estilo login, no el de admin) -->
    <nav class="nav-floating">
      <div class="nav-wrapper">
        <router-link to="/" class="brand">
          <img src="../../imagenes/logo.png" class="logo-white" alt="Cronos" />
          <span class="brand-name">CRONOS</span>
        </router-link>

        <div class="nav-auth">
          <router-link to="/inicio-sesion" class="link-minimal">Entrar</router-link>
          <router-link to="/registro" class="btn-glow">Únete</router-link>
        </div>
      </div>
    </nav>

    <!-- HERO SECTION (estilo tarjeta como login) -->
    <section class="hero-section">
      <div class="hero-card">
        <div class="hero-badge">NUEVO: Gestión 2026</div>
        <h1 class="hero-title">Domina tu tiempo<br>académico.</h1>
        <p class="hero-description">
          Cronos es la plataforma inteligente diseñada para la UTEQ que organiza horarios,
          aulas y asesorías en un solo lugar.
        </p>
        <div class="hero-buttons">
          <router-link to="/registro" class="btn-primary-hero">
            Empezar gratis <i class="fas fa-arrow-right"></i>
          </router-link>
          <a @click="scrollToFeatures" class="btn-secondary-hero">
            Saber más <i class="fas fa-chevron-down"></i>
          </a>
        </div>
      </div>
      <div class="hero-image">
        <div class="image-wrapper">
          <img src="../../imagenes/logo1.png" class="floating-logo" alt="Cronos App" />
          <div class="orb"></div>
        </div>
      </div>
    </section>

    <!-- STATS -->
    <section class="stats-section">
      <div class="stats-card">
        <div class="stat-item" v-for="stat in stats" :key="stat.label">
          <h3 class="stat-number">{{ stat.number }}</h3>
          <p class="stat-label">{{ stat.label }}</p>
        </div>
      </div>
    </section>

    <!-- FEATURES -->
    <section id="features" class="features-section">
      <h2 class="section-title">Diseñado para la eficiencia</h2>
      <div class="features-grid">
        <div v-for="feature in features" :key="feature.title" class="feature-card">
          <div class="feature-icon"><i :class="['fas', feature.icon]"></i></div>
          <h3>{{ feature.title }}</h3>
          <p>{{ feature.description }}</p>
        </div>
      </div>
    </section>

    <!-- HOW IT WORKS -->
    <section class="how-it-works">
      <h2 class="section-title">¿Cómo funciona?</h2>
      <div class="steps-container">
        <div v-for="(step, index) in steps" :key="index"
          :class="['step-card', { 'active': currentStep === index }]" @click="goToStep(index)">
          <div class="step-number">{{ index + 1 }}</div>
          <div class="step-content">
            <h4>{{ step.title }}</h4>
            <p v-if="currentStep === index">{{ step.description }}</p>
          </div>
        </div>
      </div>
    </section>

    <!-- FOOTER -->
    <footer class="footer-landing">
      <div class="footer-content">
        <div class="footer-brand">
          <img src="../../imagenes/logo.png" class="footer-logo" alt="Cronos" />
          <p>La revolución en gestión de horarios escolares.</p>
        </div>
        <div class="footer-contact">
          <h5>Contacto</h5>
          <a href="mailto:cronos.school2025@gmail.com">
            <i class="fas fa-envelope"></i> cronos.school2025@gmail.com
          </a>
          <span><i class="fas fa-map-marker-alt"></i> Querétaro, México</span>
        </div>
      </div>
      <div class="footer-copyright">
        &copy; 2026 CRONOS UTEQ. Todos los derechos reservados.
      </div>
    </footer>
  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted, onBeforeMount } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const showLanding = ref(false)
const currentStep = ref(0)
let intervalId = null

const stats = ref([
  { number: '+2k', label: 'Usuarios' },
  { number: '100%', label: 'Seguro' },
  { number: '24/7', label: 'Soporte' }
])

const features = ref([
  { icon: 'fa-magic', title: 'Auto-Generación', description: 'Algoritmos que crean horarios sin traslapes en segundos.' },
  { icon: 'fa-user-graduate', title: 'Vista Estudiante', description: 'Tu horario siempre a la mano, optimizado para móvil.' },
  { icon: 'fa-chalkboard-teacher', title: 'Gestión Docente', description: 'Control total sobre aulas y horas de asesoría.' },
  { icon: 'fa-file-export', title: 'Exportación Directa', description: 'Descarga reportes y horarios en PDF al instante.' }
])

const steps = ref([
  { title: 'Regístrate', description: 'Crea tu cuenta institucional en menos de 1 minuto.' },
  { title: 'Personaliza', description: 'Agrega tus materias, grupos o consulta tu asignación.' },
  { title: 'Visualiza', description: 'Disfruta de tu horario organizado y limpio.' }
])

const checkExistingSession = () => {
  const token = localStorage.getItem('access_token')
  const rol = localStorage.getItem('rol')
  if (token && rol) {
    redirectByRole(rol)
    return true
  }
  return false
}

const redirectByRole = (rol) => {
  const routes = {
    'estudiante': 'alumno-home',
    'admin': 'dashboard',
    'profesor': 'profesor-home'
  }
  router.push({ name: routes[rol] || 'login' })
}

const goToStep = (i) => {
  currentStep.value = i
}

const nextStep = () => {
  currentStep.value = (currentStep.value + 1) % steps.value.length
}

const scrollToFeatures = () => {
  document.getElementById('features')?.scrollIntoView({ behavior: 'smooth' })
}

onBeforeMount(() => {
  if (!checkExistingSession()) {
    showLanding.value = true
  }
})

onMounted(() => {
  if (showLanding.value) {
    intervalId = setInterval(nextStep, 5000)
  }
})

onUnmounted(() => {
  clearInterval(intervalId)
})
</script>

<style scoped>
/* =======================
   LANDING PAGE - ESTILO IDÉNTICO AL LOGIN
   Gradiente animado, formas flotantes, glassmorphism
======================= */

.landing-wrapper {
  position: relative;
  min-height: 100vh;
  overflow-x: hidden;
  background: linear-gradient(-45deg, #e3f2fd, #bbdefb, #e1f5fe, #3abef9);
  background-size: 400% 400%;
  animation: gradientBG 15s ease infinite;
}

@keyframes gradientBG {
  0% { background-position: 0% 50%; }
  50% { background-position: 100% 50%; }
  100% { background-position: 0% 50%; }
}

/* Formas decorativas (igual que login) */
.bg-shapes .shape {
  position: fixed;
  background: rgba(255, 255, 255, 0.3);
  border-radius: 50%;
  filter: blur(50px);
  z-index: 0;
  pointer-events: none;
}

.shape-1 {
  width: 300px;
  height: 300px;
  top: -100px;
  left: -100px;
  animation: float 8s infinite;
}

.shape-2 {
  width: 400px;
  height: 400px;
  bottom: -150px;
  right: -100px;
  animation: float 10s infinite reverse;
}

.shape-3 {
  width: 200px;
  height: 200px;
  top: 20%;
  right: 10%;
  animation: float 12s infinite;
}

@keyframes float {
  0%, 100% { transform: translateY(0) scale(1); }
  50% { transform: translateY(30px) scale(1.1); }
}

/* NAVBAR FLOTANTE (igual al login) */
.nav-floating {
  position: fixed;
  top: 20px;
  left: 50%;
  transform: translateX(-50%);
  width: 90%;
  max-width: 1200px;
  z-index: 1000;
  background: rgba(255, 255, 255, 0.85);
  backdrop-filter: blur(12px);
  padding: 12px 25px;
  border-radius: 50px;
  border: 1px solid rgba(255, 255, 255, 0.3);
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
}

.nav-wrapper {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.brand {
  display: flex;
  align-items: center;
  gap: 10px;
  text-decoration: none;
}

.logo-white {
  height: 35px;
}

.brand-name {
  color: #1e293b;
  font-weight: 900;
  letter-spacing: 2px;
  font-size: 1.2rem;
}

.link-minimal {
  color: #475569;
  text-decoration: none;
  margin-right: 20px;
  font-weight: 600;
  transition: 0.3s;
}

.link-minimal:hover {
  color: #3abef9;
}

.btn-glow {
  background: #3abef9;
  color: white;
  padding: 10px 25px;
  border-radius: 50px;
  text-decoration: none;
  font-weight: 700;
  transition: 0.3s;
  box-shadow: 0 2px 10px rgba(58, 190, 249, 0.3);
}

.btn-glow:hover {
  background: #29a9e0;
  transform: translateY(-2px);
}

/* HERO SECTION */
.hero-section {
  padding: 180px 10% 100px;
  display: grid;
  grid-template-columns: 1fr 0.8fr;
  gap: 50px;
  position: relative;
  z-index: 1;
  min-height: 100vh;
  align-items: center;
}

/* Tarjeta principal (estilo glass como login) */
.hero-card {
  background: rgba(255, 255, 255, 0.85);
  backdrop-filter: blur(10px);
  padding: 50px;
  border-radius: 28px;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
  animation: slideUp 0.8s ease-out;
}

.hero-badge {
  background: rgba(58, 190, 249, 0.15);
  color: #3abef9;
  padding: 6px 16px;
  border-radius: 20px;
  display: inline-block;
  font-size: 0.8rem;
  font-weight: 700;
  margin-bottom: 24px;
}

.hero-title {
  font-size: 3rem;
  font-weight: 800;
  line-height: 1.2;
  color: #1e293b;
  margin-bottom: 20px;
}

.hero-description {
  font-size: 1.1rem;
  color: #475569;
  margin-bottom: 32px;
  line-height: 1.6;
}

.hero-buttons {
  display: flex;
  align-items: center;
  gap: 20px;
  flex-wrap: wrap;
}

.btn-primary-hero {
  background: #1e293b;
  color: white;
  padding: 14px 32px;
  border-radius: 14px;
  text-decoration: none;
  font-weight: 700;
  transition: 0.3s;
  display: inline-flex;
  align-items: center;
  gap: 10px;
}

.btn-primary-hero:hover {
  background: #3abef9;
  transform: translateY(-2px);
  box-shadow: 0 10px 20px rgba(58, 190, 249, 0.3);
}

.btn-secondary-hero {
  background: transparent;
  color: #3abef9;
  padding: 14px 32px;
  border-radius: 14px;
  text-decoration: none;
  font-weight: 700;
  cursor: pointer;
  display: inline-flex;
  align-items: center;
  gap: 10px;
  border: 1px solid #3abef9;
  transition: 0.3s;
}

.btn-secondary-hero:hover {
  background: rgba(58, 190, 249, 0.1);
  transform: translateY(-2px);
}

/* Hero Image */
.hero-image {
  display: flex;
  justify-content: center;
  align-items: center;
}

.image-wrapper {
  position: relative;
}

.floating-logo {
  height: 280px;
  animation: floatImage 6s ease-in-out infinite;
  filter: drop-shadow(0 15px 25px rgba(0, 0, 0, 0.15));
  position: relative;
  z-index: 2;
}

.orb {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 300px;
  height: 300px;
  background: #3abef9;
  filter: blur(80px);
  opacity: 0.3;
  border-radius: 50%;
}

@keyframes floatImage {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-20px); }
}

/* STATS SECTION */
.stats-section {
  padding: 60px 10%;
  position: relative;
  z-index: 1;
}

.stats-card {
  background: rgba(255, 255, 255, 0.85);
  backdrop-filter: blur(10px);
  border-radius: 28px;
  padding: 50px;
  display: flex;
  justify-content: center;
  gap: 80px;
  flex-wrap: wrap;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
}

.stat-number {
  font-size: 3rem;
  font-weight: 800;
  color: #3abef9;
  margin: 0;
}

.stat-label {
  color: #475569;
  font-weight: 600;
  margin: 5px 0 0;
}

/* FEATURES SECTION */
.features-section {
  padding: 100px 10%;
  position: relative;
  z-index: 1;
}

.section-title {
  text-align: center;
  font-size: 2.5rem;
  font-weight: 800;
  color: #1e293b;
  margin-bottom: 60px;
}

.features-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
  gap: 30px;
}

.feature-card {
  background: rgba(255, 255, 255, 0.85);
  backdrop-filter: blur(10px);
  padding: 40px 30px;
  border-radius: 20px;
  transition: all 0.3s ease;
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.05);
}

.feature-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 20px 35px rgba(0, 0, 0, 0.1);
}

.feature-icon {
  font-size: 2.5rem;
  color: #3abef9;
  margin-bottom: 20px;
}

.feature-card h3 {
  font-size: 1.3rem;
  font-weight: 700;
  color: #1e293b;
  margin-bottom: 12px;
}

.feature-card p {
  color: #475569;
  font-size: 0.9rem;
  line-height: 1.6;
  margin: 0;
}

/* HOW IT WORKS */
.how-it-works {
  padding: 80px 10%;
  position: relative;
  z-index: 1;
}

.steps-container {
  max-width: 600px;
  margin: 0 auto;
}

.step-card {
  display: flex;
  gap: 20px;
  padding: 24px 30px;
  background: rgba(255, 255, 255, 0.85);
  backdrop-filter: blur(10px);
  border-radius: 20px;
  margin-bottom: 16px;
  cursor: pointer;
  transition: all 0.3s ease;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
}

.step-card:hover {
  transform: translateX(5px);
}

.step-card.active {
  background: rgba(58, 190, 249, 0.15);
  border-left: 4px solid #3abef9;
}

.step-number {
  width: 44px;
  height: 44px;
  background: #3abef9;
  color: white;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: 800;
  font-size: 1.2rem;
  flex-shrink: 0;
}

.step-content h4 {
  color: #1e293b;
  font-size: 1.1rem;
  font-weight: 700;
  margin: 0;
}

.step-content p {
  color: #475569;
  margin: 8px 0 0;
  font-size: 0.9rem;
  line-height: 1.5;
}

/* FOOTER */
.footer-landing {
  background: rgba(255, 255, 255, 0.9);
  backdrop-filter: blur(10px);
  padding: 60px 10% 30px;
  position: relative;
  z-index: 1;
  margin-top: 60px;
}

.footer-content {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  gap: 40px;
  padding-bottom: 40px;
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
}

.footer-brand {
  max-width: 300px;
}

.footer-logo {
  height: 45px;
  margin-bottom: 16px;
}

.footer-brand p {
  color: #475569;
  font-size: 0.9rem;
  line-height: 1.6;
}

.footer-contact h5 {
  color: #3abef9;
  font-size: 1rem;
  margin: 0 0 20px;
  text-transform: uppercase;
  letter-spacing: 1px;
}

.footer-contact a,
.footer-contact span {
  display: flex;
  align-items: center;
  gap: 10px;
  color: #475569;
  text-decoration: none;
  font-size: 0.9rem;
  margin-bottom: 12px;
  transition: color 0.3s ease;
}

.footer-contact a:hover {
  color: #3abef9;
}

.footer-contact i {
  width: 20px;
  color: #3abef9;
}

.footer-copyright {
  text-align: center;
  padding-top: 30px;
  color: #94a3b8;
  font-size: 0.8rem;
}

/* Animaciones */
@keyframes slideUp {
  from {
    opacity: 0;
    transform: translateY(30px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

/* ===== RESPONSIVE ===== */
@media (max-width: 900px) {
  .hero-section {
    grid-template-columns: 1fr;
    text-align: center;
    padding-top: 150px;
  }
  
  .hero-description {
    margin-left: auto;
    margin-right: auto;
  }
  
  .hero-buttons {
    justify-content: center;
  }
  
  .hero-image {
    display: none;
  }
  
  .stats-card {
    gap: 40px;
  }
  
  .section-title {
    font-size: 2rem;
  }
  
  .footer-content {
    flex-direction: column;
    text-align: center;
    align-items: center;
  }
  
  .footer-contact a,
  .footer-contact span {
    justify-content: center;
  }
}

@media (max-width: 600px) {
  .hero-card {
    padding: 30px 20px;
  }
  
  .hero-title {
    font-size: 2rem;
  }
  
  .hero-buttons {
    flex-direction: column;
    width: 100%;
  }
  
  .btn-primary-hero,
  .btn-secondary-hero {
    width: 100%;
    justify-content: center;
  }
  
  .stats-card {
    flex-direction: column;
    align-items: center;
    text-align: center;
    padding: 30px;
  }
  
  .step-card {
    flex-direction: column;
    text-align: center;
    align-items: center;
  }
  
  .features-grid {
    grid-template-columns: 1fr;
  }
  
  .brand-name {
    display: none;
  }
  
  .nav-floating {
    width: 95%;
    padding: 10px 15px;
  }
}
</style>