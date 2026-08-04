# Tarot Live Interactive - Multiplatform

Este proyecto es una plataforma de Tarot interactiva diseñada para integrarse con **TikTok Live**. Permite realizar lecturas en tiempo real basadas en la interacción de los usuarios (regalos, comentarios, follows).

## 🚀 Características
- **Multiplataforma:** Web (Overlay para OBS) y App (Gestión).
- **Interacción en Tiempo Real:** Conexión con eventos de TikTok.
- **IA Personalizada:** Interpretaciones generadas en milisegundos vinculadas al perfil del usuario.
- **Motor de Tarot:** Lógica de cartas basada en semillas únicas por usuario.

## 🛠 Tech Stack
- **Frontend:** Kotlin Multiplatform + Compose Multiplatform (Web/Android).
- **Backend Bridge:** Node.js (TikTok Live Connector).
- **IA:** Gemini API / Groq (Modelos LPU de baja latencia).

## 📂 Estructura
- `/app`: Versión Android.
- `/web`: Versión Web/Overlay (en desarrollo).
- `/shared`: Lógica de Tarot e IA compartida.

---
Desarrollado para la comunidad de Live Streaming.
