# RAINVOID
**by [rainisveryswag](https://github.com/rainisveryswag) (yousra)**

> *Two fragments. One void. Signal received.*

---

## What is this?

**RAINVOID** is a dark-themed Android app built around fragment navigation. It has two interactive modules — **PULSE** and **STATIC** — each demonstrating a different Android Fragment behavior: UI interaction and state preservation.

The whole thing runs inside a single `MainActivity` that swaps fragments in and out of a container, styled with a cyberpunk aesthetic — black backgrounds, neon cyan accents, monospace fonts throughout.

---

## Features

### `// PULSE` — Signal Module
An interactive terminal-style fragment.

- Displays `AWAITING SIGNAL_` on load
- Press `[ TRANSMIT ]` and it fires back:
  ```
  >_ SIGNAL RECEIVED // rainisveryswag
  ```
- Lifecycle events logged to Logcat under the tag `PULSE`

### `// STATIC` — Frequency Tuner
A state-aware seekbar fragment.

- Displays `FREQ: 0` to `FREQ: 100` in real time as you drag
- **Survives device rotation** — seekbar position is saved via `onSaveInstanceState` and restored in `onViewCreated`
- Subtitle hint: `DRAG TO TUNE`

---

## How Navigation Works

`MainActivity` holds a `FrameLayout` (the fragment container). Tapping a tab calls `FragmentManager.replace()` which swaps out the current fragment. Each swap is added to the back stack so the system back button works as expected.

The active tab gets a **neon cyan** background with black text. The inactive tab goes dark with cyan text. This is toggled via `setActiveButton()` which updates `backgroundTintList` and `textColor` programmatically.

```
[ // PULSE (active) ] | [ // STATIC (inactive) ]
         ↓
   FrameLayout container
         ↓
   FragmentOne or FragmentTwo
```

---

## Fragment Lifecycle Details

### FragmentOne (PULSE)
| Event | Behavior |
|-------|----------|
| `onViewCreated` | Binds views, sets button click listener |
| `onResume` | Logs `PULSE fragment online` |
| `onPause` | Logs `PULSE fragment suspended` |

### FragmentTwo (STATIC)
| Event | Behavior |
|-------|----------|
| `onViewCreated` | Binds views, restores saved state if present |
| `onSaveInstanceState` | Saves seekbar progress to Bundle with key `freq_progress` |
| `onProgressChanged` | Updates `FREQ: X` label live |

---

## Tech Stack

| Layer | Tech |
|-------|------|
| Language | Java |
| Platform | Android (minSdk 31 / Android 12+) |
| UI Framework | AndroidX Jetpack + Material3 |
| Navigation | Fragment back-stack via `FragmentManager` |
| Theme | `Theme.Material3.Dark.NoActionBar` |
| App ID | `com.rainisveryswag.rainvoid` |

---

## Color Palette

| Token | Hex | Role |
|-------|-----|------|
| `void_black` | `#0A0A0F` | App background |
| `void_surface` | `#111118` | Header / nav bar |
| `void_card` | `#1A1A2E` | SeekBar track |
| `neon_cyan` | `#00E5FF` | Primary accent, active tab, interactive elements |
| `neon_cyan_dim` | `#003D4D` | Subtle accent divider |
| `neon_purple` | `#7C4DFF` | Secondary accent (theme) |
| `text_primary` | `#D0D0E0` | Body text |
| `text_dim` | `#3A3A5C` | Muted labels |

---

## Setup

1. Clone or download the project
2. Open in **Android Studio**
3. Let Gradle sync
4. Run on a device or emulator with **Android 12+** (API 31)

---

## Project Structure

```
app/src/main/
├── java/com/example/lab4/
│   ├── MainActivity.java       ← tab navigation + fragment swapping
│   ├── FragmentOne.java        ← PULSE: button → signal response
│   └── FragmentTwo.java        ← STATIC: seekbar + state preservation
└── res/
    ├── layout/
    │   ├── activity_main.xml   ← header + tabs + container
    │   ├── fragment_one.xml    ← PULSE UI
    │   └── fragment_two.xml    ← STATIC UI
    └── values/
        ├── colors.xml          ← dark cyberpunk palette
        ├── strings.xml         ← all UI text
        └── themes.xml          ← Material3 Dark theme
```

---

*RAINVOID — built by yousra · rainisveryswag*
