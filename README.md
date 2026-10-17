# Dash Deck — instrument display designer for Jetour G700

Standalone Android app extracted from QuickDock. It does one thing: lets you design the instrument display (Display 2) from live widgets and deploy it.

## Use
- **Top:** simulation of the instrument display, a 24-column grid whose proportions follow the real display when visible to the app.
- **Bottom:** widget library. Drag (or long-press then drag) a widget onto the display.
- **On the display:** tap a widget to select → drag to **move**, drag ◢ to **resize**, ✕ to **remove**, ⚙ for **settings**. Widgets snap to the grid and cannot overlap.
- **Deploy** saves and opens the layout on the chosen display (default Display 2, change with *Display ▾*). *Revert* returns to the deployed layout, *Stop* closes the deck, *Preview here* shows it on the current screen.
- **Setup** shows the optional permissions (location, notification access, display over other apps) and the ADB command for each.
- Edits are kept as a draft until you press Deploy.

If Android refuses to open Display 2: `adb shell am start --display 2 -n com.dashdeck.app/.DeckDisplayActivity`

## Widgets
| Widget | Notes |
|---|---|
| Weather | Open-Meteo (internet). City or the car's location. |
| Media player | Track + controls for any music app. Needs notification access. |
| Seat belts | Belt status; alarm + red banner if the car moves unbuckled. Set up once from ⚙. Runs `BeltService` in the background and restarts after boot. |
| Prayer times | Next prayer, countdown, five prayers; city, method, per-prayer adjustment. |

## Build
Upload this folder (with `.github` and `autolink-stubs`) to a GitHub repo. *Actions → Build Dash Deck APK* produces `DashDeck.apk` in Releases. Optional `SIGNING_KEY` secret (base64 `.jks`, alias `dashdeck`, password `dashdeck-sign-2026`) lets updates install over old builds. Optional Pages source "GitHub Actions" serves the browser install page (`site/`).

## Differences from QuickDock
- Package `com.dashdeck.app`, preferences file `dashdeck` — installs side by side with QuickDock; layouts/settings are **not** shared (re-create them once).
- Removed: edge tab and drawer, app switcher, all-apps grid, favorites, self-updater, and the permissions only they needed (usage stats, query-all-packages, install packages, kill background).
- The deck designer is now the launcher activity.
- Added a Setup dialog and a launcher icon.
