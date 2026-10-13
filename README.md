# Sleep+

A small Fabric mod for Minecraft 26.3 that makes sleeping more rewarding and helps you figure out why you can't fall asleep.

## ✨ Features

### 😴 Alertness Effect
When a player wakes up **in the morning** (after sleeping through the night), they receive the **Alertness** effect for **5 minutes**:
- **+10%** movement speed.

The effect is **not** applied if the player simply lies down and gets up immediately — you actually need to sleep until morning.

### 👹 Monster Highlighting
If a player tries to sleep but nearby monsters are preventing it, they are **highlighted** (Glowing effect) for **3 seconds**. This helps you quickly find and deal with unwanted guests.

## 📦 Installation

1. Install **Fabric Loader** version `0.19.5+` for Minecraft `26.3`.
2. Download and place the following into your `mods` folder:
    - [Fabric API](https://modrinth.com/mod/fabric-api) `0.160.5+26.3` or newer
    - **Sleep+** (this mod)
3. Launch the game.

## ⚙️ Requirements

| Component | Version |
|---|---|
| Minecraft | 26.3 |
| Fabric Loader | 0.19.5+ |
| Fabric API | 0.160.5+26.3 |
| Java | 25+ |

## 🛠️ Building from Source

```bash
git clone <repository-url>
cd sleep-plus-26.3
./gradlew build