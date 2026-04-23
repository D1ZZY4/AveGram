# Design System

The visual language behind AveGram — calm, modern, and unmistakably dark.

## Color tokens

### Brand

| Token | Hex | Use |
|---|---|---|
| `primary` | `#2196F3` | Buttons, links, accents |
| `primary-dark` | `#1565C0` | Pressed / hover states |
| `primary-soft` | `#BBDEFB` | Selection, focus rings |

### Surface

| Token | Hex | Use |
|---|---|---|
| `bg-light` | `#FAFCFF` | Light theme background |
| `bg-dark` | `#0D1117` | Dark theme background |
| `card-dark` | `#1C2232` | Glass cards in dark mode |
| `card-light` | `#FFFFFF` | Cards in light mode |
| `divider` | `rgba(255,255,255,0.06)` | Hairline separators (dark) |

### Semantic

| Token | Hex |
|---|---|
| `success` | `#4CAF50` |
| `warning` | `#FFC107` |
| `danger`  | `#F44336` |
| `info`    | `#2196F3` |

## Typography

| Role | Font | Size | Weight |
|---|---|---|---|
| Display | System | 28–32 sp | 700 |
| Title | System | 20–22 sp | 600 |
| Body | System | 14–16 sp | 400 |
| Caption | System | 12 sp | 400 |
| Mono | System mono | 13 sp | 500 |

Line-height is `1.4×` font size unless overridden.

## Shape

| Element | Radius |
|---|---|
| Cards & sheets | `20 dp` |
| Buttons & chips | `16 dp` |
| Dialogs | `24 dp` |
| Avatars | `50%` (circle) |
| Inputs | `12 dp` |

## Elevation

Dark mode uses **glass** instead of true elevation:

```css
background: rgba(28, 34, 50, 0.6);
border: 1px solid rgba(255, 255, 255, 0.06);
backdrop-filter: blur(14px);
```

Light mode uses subtle Material elevation (1–4 dp).

## Motion

| Type | Duration | Curve |
|---|---|---|
| Micro (toggles, ripples) | 120 ms | `linear` |
| Standard (sheets, dialogs) | 240 ms | `ease-out` |
| Emphasized (page transitions) | 320 ms | `cubic-bezier(0.2, 0, 0, 1)` |

## Iconography

- Stroke width `2 dp`
- 24 dp grid by default, 20 dp in dense lists
- Filled variant for selected states

## Spacing scale

`4 · 8 · 12 · 16 · 20 · 24 · 32 · 48 · 64` (dp)

Use the smallest value that maintains a comfortable rhythm. Default
content padding is `16 dp`.
