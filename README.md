# 🕑 Reminder System

Um sistema de **lembretes com notificações sonoras**, desenvolvido em **Java 19 + JavaFX 19**, utilizando **ScheduledExecutorService** para o agendamento de tarefas e estruturado segundo os **princípios SOLID**.

---

## Funcionalidades
- ✅ Criação de lembretes com título, descrição e horário.
- ✅ Agendamento eficiente com `ScheduledExecutorService`.
- ✅ Validação automática de configurações antes da execução.
- ✅ Notificação sonora personalizada quando o lembrete dispara.
- ✅ Interface gráfica moderna construída com **JavaFX**.
- ✅ Organização modular respeitando os princípios **SOLID**.

---

## Como usar o sistema

O sistema utiliza um arquivo de configuração para personalizar as notificações.  
Basta acessar `config.properties` no diretório raiz do projeto e modificar os seguintes campos:

```properties
# Texto da notificação
title=Minha Notificação
message=Este é um lembrete automático gerado pelo sistema.

# Posição da notificação (TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT)
position=TOP_RIGHT

# Tempo em segundos que a notificação fica visível
duration=10

# Intervalo entre notificações em minutos
interval=30

# Caminho para imagem opcional (tamanho de 64px é o ideal)
image=icons/icon.png
```

---

## Tecnologias Utilizadas
- **Java 19**
- **JavaFX 19**
- **Maven**
- **ScheduledExecutorService** (agendamento de lembretes)
- **javax.sound.sampled** (áudio de notificação)
