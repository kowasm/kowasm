// package dev.scottpierce.html.writer.style
//
// /**
// * CSS Property Names
// *
// * http://www.w3schools.com/cssref/default.asp
// */
// object CssProperty {
//    const val ALIGN_ITEMS = "align-items"
//    const val BACKGROUND = "background"
//    const val COLOR = "color"
//    const val DISPLAY = "display"
//    const val FLEX_DIRECTION = "flex-direction"
//    const val GRID_COLUMN = "grid-column"
//    const val GRID_TEMPLATE_COLUMNS = "grid-template-columns"
//    const val GRID_TEMPLATE_ROWS = "grid-template-rows"
//    const val JUSTIFY_CONTENT = "justify-content"
//    const val OPACITY = "opacity"
//    const val MARGIN = "margin"
//    const val MARGIN_LEFT = "margin-left"
//    const val MARGIN_RIGHT = "margin-right"
//    const val MARGIN_TOP = "margin-top"
//    const val MARGIN_BOTTOM = "margin-bottom"
//    const val PADDING = "padding"
//    const val PADDING_LEFT = "padding-left"
//    const val PADDING_RIGHT = "padding-right"
//    const val PADDING_TOP = "padding-top"
//    const val PADDING_BOTTOM = "padding-bottom"
// }
//
// // Align Items
// val Style.alignItems: AlignItems?
//    get() = getProperty(CssProperty.ALIGN_ITEMS)
//
// var StyleBuilder.alignItems: AlignItems?
//    get() = getProperty(CssProperty.ALIGN_ITEMS)
//    set(value) = setProperty(CssProperty.ALIGN_ITEMS, value)
//
// // Background
// val Style.background: Color?
//    get() = getProperty(CssProperty.BACKGROUND)
//
// var StyleBuilder.background: Color?
//    get() = getProperty(CssProperty.BACKGROUND)
//    set(value) = setProperty(CssProperty.BACKGROUND, value)
//
// // Color
// val Style.color: Color?
//    get() = getProperty(CssProperty.COLOR)
//
// var StyleBuilder.color: Color?
//    get() = getProperty(CssProperty.COLOR)
//    set(value) = setProperty(CssProperty.COLOR, value)
//
// // Display
// val Style.display: Display?
//    get() = getProperty(CssProperty.DISPLAY)
//
// var StyleBuilder.display: Display?
//    get() = getProperty(CssProperty.DISPLAY)
//    set(value) = setProperty(CssProperty.DISPLAY, value)
//
// // Flex Direction
// val Style.flexDirection: FlexDirection?
//    get() = getProperty(CssProperty.FLEX_DIRECTION)
//
// var StyleBuilder.flexDirection: FlexDirection?
//    get() = getProperty(CssProperty.FLEX_DIRECTION)
//    set(value) = setProperty(CssProperty.FLEX_DIRECTION, value)
//
// // Grid Column
// val Style.gridColumn: GridColumn?
//    get() = getProperty(CssProperty.GRID_COLUMN)
//
// var StyleBuilder.gridColumn: GridColumn?
//    get() = getProperty(CssProperty.GRID_COLUMN)
//    set(value) = setProperty(CssProperty.GRID_COLUMN, value)
//
// // Grid Template Columns
// val Style.gridTemplateColumns: String?
//    get() = getProperty(CssProperty.GRID_TEMPLATE_COLUMNS)
//
// var StyleBuilder.gridTemplateColumns: String?
//    get() = getProperty(CssProperty.GRID_TEMPLATE_COLUMNS)
//    set(value) = setProperty(CssProperty.GRID_TEMPLATE_COLUMNS, value)
//
// // Grid Template Rows
// val Style.gridTemplateRows: String?
//    get() = getProperty(CssProperty.GRID_TEMPLATE_ROWS)
//
// var StyleBuilder.gridTemplateRows: String?
//    get() = getProperty(CssProperty.GRID_TEMPLATE_ROWS)
//    set(value) = setProperty(CssProperty.GRID_TEMPLATE_ROWS, value)
//
// // Justify Content
// val Style.justifyContent: JustifyContent?
//    get() = getProperty(CssProperty.JUSTIFY_CONTENT)
//
// var StyleBuilder.justifyContent: JustifyContent?
//    get() = getProperty(CssProperty.JUSTIFY_CONTENT)
//    set(value) = setProperty(CssProperty.JUSTIFY_CONTENT, value)
//
// // Opacity
// val Style.opacity: Float?
//    get() = getProperty(CssProperty.OPACITY)
//
// var StyleBuilder.opacity: Float?
//    get() = getProperty(CssProperty.OPACITY)
//    set(value) = setProperty(CssProperty.OPACITY, value)
//
// // Margin
// val Style.margin: Dimension?
//    get() = getProperty(CssProperty.MARGIN)
//
// var StyleBuilder.margin: Dimension?
//    get() = getProperty(CssProperty.MARGIN)
//    set(value) = setProperty(CssProperty.MARGIN, value)
//
// // Margin Left
// val Style.marginLeft: Dimension?
//    get() = getProperty(CssProperty.MARGIN_LEFT)
//
// var StyleBuilder.marginLeft: Dimension?
//    get() = getProperty(CssProperty.MARGIN_LEFT)
//    set(value) = setProperty(CssProperty.MARGIN_LEFT, value)
//
// // Margin Right
// val Style.marginRight: Dimension?
//    get() = getProperty(CssProperty.MARGIN_RIGHT)
//
// var StyleBuilder.marginRight: Dimension?
//    get() = getProperty(CssProperty.MARGIN_RIGHT)
//    set(value) = setProperty(CssProperty.MARGIN_RIGHT, value)
//
// // Margin Top
// val Style.marginTop: Dimension?
//    get() = getProperty(CssProperty.MARGIN_TOP)
//
// var StyleBuilder.marginTop: Dimension?
//    get() = getProperty(CssProperty.MARGIN_TOP)
//    set(value) = setProperty(CssProperty.MARGIN_TOP, value)
//
// // Margin Bottom
// val Style.marginBottom: Dimension?
//    get() = getProperty(CssProperty.MARGIN_BOTTOM)
//
// var StyleBuilder.marginBottom: Dimension?
//    get() = getProperty(CssProperty.MARGIN_BOTTOM)
//    set(value) = setProperty(CssProperty.MARGIN_BOTTOM, value)
//
// // Padding
// val Style.padding: Dimension?
//    get() = getProperty(CssProperty.PADDING)
//
// var StyleBuilder.padding: Dimension?
//    get() = getProperty(CssProperty.PADDING)
//    set(value) = setProperty(CssProperty.PADDING, value)
//
// // Padding Left
// val Style.paddingLeft: Dimension?
//    get() = getProperty(CssProperty.PADDING_LEFT)
//
// var StyleBuilder.paddingLeft: Dimension?
//    get() = getProperty(CssProperty.PADDING_LEFT)
//    set(value) = setProperty(CssProperty.PADDING_LEFT, value)
//
// // Padding Right
// val Style.paddingRight: Dimension?
//    get() = getProperty(CssProperty.PADDING_RIGHT)
//
// var StyleBuilder.paddingRight: Dimension?
//    get() = getProperty(CssProperty.PADDING_RIGHT)
//    set(value) = setProperty(CssProperty.PADDING_RIGHT, value)
//
// // Padding Top
// val Style.paddingTop: Dimension?
//    get() = getProperty(CssProperty.PADDING_TOP)
//
// var StyleBuilder.paddingTop: Dimension?
//    get() = getProperty(CssProperty.PADDING_TOP)
//    set(value) = setProperty(CssProperty.PADDING_TOP, value)
//
// // Padding Bottom
// val Style.paddingBottom: Dimension?
//    get() = getProperty(CssProperty.PADDING_BOTTOM)
//
// var StyleBuilder.paddingBottom: Dimension?
//    get() = getProperty(CssProperty.PADDING_BOTTOM)
//    set(value) = setProperty(CssProperty.PADDING_BOTTOM, value)
//
// @Suppress("UNCHECKED_CAST")
// private fun <T> Style.getProperty(property: String): T? = null //properties[property] as T?
//
// private fun <T> StyleBuilder.setProperty(property: String, value: T?) {
//    properties[property] = value
// }
//
// // var Style.opacity by PropertyHandler("opacity")
// //
// // // Background and Border Properties
// // var Style.background by StringPropertyHandler("background")
// // var Style.backgroundAttachment by PropertyHandler("background-attachment")
// // var Style.backgroundBlendMode by PropertyHandler("background-blend-mode")
// // var Style.backgroundColor by ColorPropertyHandler("background-color")
// // var Style.backgroundImage by PropertyHandler("background-image")
// // var Style.backgroundPosition by PropertyHandler("background-position")
// // var Style.backgroundRepeat by PropertyHandler("background-repeat")
// // var Style.backgroundClip by PropertyHandler("background-clip")
// // var Style.backgroundOrigin by PropertyHandler("background-origin")
// // var Style.backgroundSize by PropertyHandler("background-size")
// // var Style.border by PropertyHandler("border")
// // var Style.borderBottom by PropertyHandler("border-bottom")
// // var Style.borderBottomColor by ColorPropertyHandler("border-bottom-color")
// // var Style.borderBottomLeftRadius by PropertyHandler("border-bottom-left-radius")
// // var Style.borderBottomRightRadius by PropertyHandler("border-bottom-right-radius")
// // var Style.borderBottomStyle by PropertyHandler("border-bottom-style")
// // var Style.borderBottomWidth by PropertyHandler("border-bottom-width")
// // var Style.borderColor by ColorPropertyHandler("border-color")
// // var Style.borderImage by PropertyHandler("border-image")
// // var Style.borderImageOutset by PropertyHandler("border-image-outset")
// // var Style.borderImageRepeat by PropertyHandler("border-image-repeat")
// // var Style.borderImageSlice by PropertyHandler("border-image-slice")
// // var Style.borderImageSource by PropertyHandler("border-image-source")
// // var Style.borderImageWidth by PropertyHandler("border-image-width")
// // var Style.borderLeft by PropertyHandler("border-left")
// // var Style.borderLeftColor by ColorPropertyHandler("border-left-color")
// // var Style.borderLeftStyle by PropertyHandler("border-left-style")
// // var Style.borderLeftWidth by PropertyHandler("border-left-width")
// // var Style.borderRadius by PropertyHandler("border-radius")
// // var Style.borderRight by PropertyHandler("border-right")
// // var Style.borderRightColor by ColorPropertyHandler("border-right-color")
// // var Style.borderRightStyle by PropertyHandler("border-right-style")
// // var Style.borderRightWidth by PropertyHandler("border-right-width")
// // var Style.borderStyle by PropertyHandler("border-style")
// // var Style.borderTop by PropertyHandler("border-top")
// // var Style.borderTopColor by ColorPropertyHandler("border-top-color")
// // var Style.borderTopLeftRadius by PropertyHandler("border-top-left-radius")
// // var Style.borderTopRightRadius by PropertyHandler("border-top-right-radius")
// // var Style.borderTopStyle by PropertyHandler("border-top-style")
// // var Style.borderTopWidth by PropertyHandler("border-top-width")
// // var Style.borderWidth by PropertyHandler("border-width")
// // var Style.boxDecorationBreak by PropertyHandler("box-decoration-break")
// // var Style.boxShadow by PropertyHandler("box-shadow")
// //
// // // Basic Box Properties
// // var Style.bottom by PropertyHandler("bottom")
// // var Style.clear by PropertyHandler("clear")
// // var Style.clip by PropertyHandler("clip")
// // var Style.display by PropertyHandler("display")
// // var Style.float by PropertyHandler("float")
// // var Style.height by PropertyHandler("height")
// // var Style.left by PropertyHandler("left")
// // var Style.margin by PropertyHandler("margin")
// // var Style.marginBottom by PropertyHandler("margin-bottom")
// // var Style.marginLeft by PropertyHandler("margin-left")
// // var Style.marginRight by PropertyHandler("margin-right")
// // var Style.marginTop by PropertyHandler("margin-top")
// // var Style.maxHeight by PropertyHandler("max-height")
// // var Style.maxWidth by PropertyHandler("max-width")
// // var Style.minHeight by PropertyHandler("min-height")
// // var Style.minWidth by PropertyHandler("min-width")
// // var Style.overflow by PropertyHandler("overflow")
// // var Style.overflowX by PropertyHandler("overflow-x")
// // var Style.overflowY by PropertyHandler("overflow-y")
// // var Style.padding by PropertyHandler("padding")
// // var Style.paddingBottom by PropertyHandler("padding-bottom")
// // var Style.paddingLeft by PropertyHandler("padding-left")
// // var Style.paddingRight by PropertyHandler("padding-right")
// // var Style.paddingTop by PropertyHandler("padding-top")
// // var Style.position by PropertyHandler("position")
// // var Style.right by PropertyHandler("right")
// // var Style.top by PropertyHandler("top")
// // var Style.visibility by PropertyHandler("visibility")
// // var Style.width by PropertyHandler("width")
// // var Style.verticalAlign by PropertyHandler("vertical-align")
// // var Style.zIndex by PropertyHandler("z-index")
// //
// // // Flexible Box Layout
// // var Style.alignContent by PropertyHandler("align-content")
// // var Style.alignItems by PropertyHandler("align-items")
// // var Style.alignSelf by PropertyHandler("align-self")
// // var Style.flex by PropertyHandler("flex")
// // var Style.flexBasis by PropertyHandler("flex-basis")
// // var Style.flexDirection by PropertyHandler("flex-direction")
// // var Style.flexFlow by PropertyHandler("flex-flow")
// // var Style.flexGrow by PropertyHandler("flex-grow")
// // var Style.flexShrink by PropertyHandler("flex-shrink")
// // var Style.flexWrap by PropertyHandler("flex-wrap")
// // var Style.justifyContent by PropertyHandler("justify-content")
// // var Style.order by PropertyHandler("order")
// //
// // // Text Properties
// // var Style.hangingPunctuation by PropertyHandler("hanging-punctuation")
// // var Style.hyphens by PropertyHandler("hyphens")
// // var Style.letterSpacing by PropertyHandler("letter-spacing")
// // var Style.lineBreak by PropertyHandler("line-break")
// // var Style.lineHeight by PropertyHandler("line-height")
// // var Style.overflowWrap by PropertyHandler("overflow-wrap")
// // var Style.tabSize by PropertyHandler("tab-size")
// // var Style.textAlign by PropertyHandler("text-align")
// // var Style.textAlignLast by PropertyHandler("text-align-last")
// // var Style.textIndent by PropertyHandler("text-indent")
// // var Style.textJustify by PropertyHandler("text-justify")
// // var Style.textTransform by PropertyHandler("text-transform")
// // var Style.whiteSpace by PropertyHandler("white-space")
// // var Style.wordBreak by PropertyHandler("word-break")
// // var Style.wordSpacing by PropertyHandler("word-spacing")
// // var Style.wordWrap by PropertyHandler("word-wrap")
// //
// // // Text Decoration Properties
// // var Style.textDecoration by PropertyHandler("text-decoration")
// // var Style.textDecorationColor by ColorPropertyHandler("text-decoration-color")
// // var Style.textDecorationLine by PropertyHandler("text-decoration-line")
// // var Style.textDecorationStyle by PropertyHandler("text-decoration-style")
// // var Style.textShadow by PropertyHandler("text-shadow")
// // var Style.textUnderlinePosition by PropertyHandler("text-underline-position")
// //
// // // Font Properties
// // var Style.font by PropertyHandler("font")
// // var Style.fontFamily by PropertyHandler("font-family")
// // var Style.fontFeatureSettings by PropertyHandler("font-feature-settings")
// // var Style.fontKerning by PropertyHandler("font-kerning")
// // var Style.fontLanguageOverride by PropertyHandler("font-language-override")
// // var Style.fontSize by PropertyHandler("font-size")
// // var Style.fontSizeAdjust by PropertyHandler("font-size-adjust")
// // var Style.fontStretch by PropertyHandler("font-stretch")
// // var Style.fontStyle by PropertyHandler("font-style")
// // var Style.fontSynthesis by PropertyHandler("font-synthesis")
// // var Style.fontVariant by PropertyHandler("font-variant")
// // var Style.fontVariantAlternates by PropertyHandler("font-variant-alternates")
// // var Style.fontVariantCaps by PropertyHandler("font-variant-caps")
// // var Style.fontVariantEastAsian by PropertyHandler("font-variant-east-asian")
// // var Style.fontVariantLigatures by PropertyHandler("font-variant-ligatures")
// // var Style.fontVariantNumeric by PropertyHandler("font-variant-numeric")
// // var Style.fontVariantPosition by PropertyHandler("font-variant-position")
// // var Style.fontWeight by PropertyHandler("font-weight")
// //
// // // Writing Modes Properties
// // var Style.direction by PropertyHandler("direction")
// // var Style.textOrientation by PropertyHandler("text-orientation")
// // var Style.textCombineUpright by PropertyHandler("text-combine-upright")
// // var Style.unicodeBidi by PropertyHandler("unicode-bidi")
// // var Style.writingMode by PropertyHandler("writing-mode")
// //
// // // Table Properties
// // var Style.borderCollapse by PropertyHandler("border-collapse")
// // var Style.borderSpacing by PropertyHandler("border-spacing")
// // var Style.captionSide by PropertyHandler("caption-side")
// // var Style.emptyCells by PropertyHandler("empty-cells")
// // var Style.tableLayout by PropertyHandler("table-layout")
// //
// // // Lists and Counters Properties
// // var Style.counterIncrement by PropertyHandler("counter-increment")
// // var Style.counterReset by PropertyHandler("counter-reset")
// // var Style.listStyle by PropertyHandler("list-style")
// // var Style.listStyleImage by PropertyHandler("list-style-image")
// // var Style.listStylePosition by PropertyHandler("list-style-position")
// // var Style.listStyleType by PropertyHandler("list-style-type")
// //
// // // Animation Properties
// // var Style.animation by PropertyHandler("animation")
// // var Style.animationDelay by PropertyHandler("animation-delay")
// // var Style.animationDirection by PropertyHandler("animation-direction")
// // var Style.animationDuration by PropertyHandler("animation-duration")
// // var Style.animationFillMode by PropertyHandler("animation-fill-mode")
// // var Style.animationIterationCount by PropertyHandler("animation-iteration-count")
// // var Style.animationName by PropertyHandler("animation-name")
// // var Style.animationPlayState by PropertyHandler("animation-play-state")
// // var Style.animationTimingFunction by PropertyHandler("animation-timing-function")
// //
// // // Transform Properties
// // var Style.backfaceVisibility by PropertyHandler("backface-visibility")
// // var Style.perspective by PropertyHandler("perspective")
// // var Style.perspectiveOrigin by PropertyHandler("perspective-origin")
// // var Style.transform by PropertyHandler("transform")
// // var Style.transformOrigin by PropertyHandler("transform-origin")
// // var Style.transformStyle by PropertyHandler("transform-style")
// //
// // // Transitions Properties
// // var Style.transition by PropertyHandler("transition")
// // var Style.transitionProperty by PropertyHandler("transition-property")
// // var Style.transitionDuration by PropertyHandler("transition-duration")
// // var Style.transitionTimingFunction by PropertyHandler("transition-timing-function")
// // var Style.transitionDelay by PropertyHandler("transition-delay")
// //
// // // Basic User Interface Properties
// // var Style.boxSizing by PropertyHandler("box-sizing")
// // var Style.content by ContentPropertyHandler("content")
// // var Style.cursor by PropertyHandler("cursor")
// // var Style.imeMode by PropertyHandler("ime-mode")
// // var Style.navDown by PropertyHandler("nav-down")
// // var Style.navIndex by PropertyHandler("nav-index")
// // var Style.navLeft by PropertyHandler("nav-left")
// // var Style.navRight by PropertyHandler("nav-right")
// // var Style.navUp by PropertyHandler("nav-up")
// // var Style.outline by PropertyHandler("outline")
// // var Style.outlineColor by ColorPropertyHandler("outline-color")
// // var Style.outlineOffset by PropertyHandler("outline-offset")
// // var Style.outlineStyle by PropertyHandler("outline-style")
// // var Style.outlineWidth by PropertyHandler("outline-width")
// // var Style.resize by PropertyHandler("resize")
// // var Style.textOverflow by PropertyHandler("text-overflow")
// //
// // // Multi-column Layout Properties
// // var Style.breakAfter by PropertyHandler("break-after")
// // var Style.breakBefore by PropertyHandler("break-before")
// // var Style.breakInside by PropertyHandler("break-inside")
// // var Style.columnCount by PropertyHandler("column-count")
// // var Style.columnFill by PropertyHandler("column-fill")
// // var Style.columnGap by PropertyHandler("column-gap")
// // var Style.columnRule by PropertyHandler("column-rule")
// // var Style.columnRuleColor by ColorPropertyHandler("column-rule-color")
// // var Style.columnRuleStyle by PropertyHandler("column-rule-style")
// // var Style.columnRuleWidth by PropertyHandler("column-rule-width")
// // var Style.columnSpan by PropertyHandler("column-span")
// // var Style.columnWidth by PropertyHandler("column-width")
// // var Style.columns by PropertyHandler("columns")
// // var Style.widows by PropertyHandler("widows")
// //
// // // Paged Media
// // var Style.orphans by PropertyHandler("orphans")
// // var Style.pageBreakAfter by PropertyHandler("page-break-after")
// // val Style.pageBreakBefore by PropertyHandler("page-break-before")
// // var Style.pageBreakInside by PropertyHandler("page-break-inside")
// //
// // // Generated Content for Paged Media
// // var Style.marks by PropertyHandler("marks")
// // var Style.quotes by PropertyHandler("quotes")
// //
// // // Filter Effects Properties
// // var Style.filter by PropertyHandler("filter")
// //
// // // Image Values and Replaced Content
// // var Style.imageOrientation by PropertyHandler("image-orientation")
// // var Style.imageRendering by PropertyHandler("image-rendering")
// // var Style.imageResolution by PropertyHandler("image-resolution")
// // var Style.objectFit by PropertyHandler("object-fit")
// // var Style.objectPosition by PropertyHandler("object-position")
// //
// // // Masking Properties
// // var Style.mask by PropertyHandler("mask")
// // var Style.maskType by PropertyHandler("mask-type")
// //
// // // Speech Properties
// // var Style.mark by PropertyHandler("mark")
// // var Style.markAfter by PropertyHandler("mark-after")
// // var Style.markBefore by PropertyHandler("mark-before")
// // var Style.phonemes by PropertyHandler("phonemes")
// // var Style.rest by PropertyHandler("rest")
// // var Style.restAfter by PropertyHandler("rest-after")
// // var Style.restBefore by PropertyHandler("rest-before")
// // var Style.voiceBalance by PropertyHandler("voice-balance")
// // var Style.voiceDuration by PropertyHandler("voice-duration")
// // var Style.voicePitch by PropertyHandler("voice-pitch")
// // var Style.voicePitchRange by PropertyHandler("voice-pitch-range")
// // var Style.voiceRate by PropertyHandler("voice-rate")
// // var Style.voiceStress by PropertyHandler("voice-stress")
// // var Style.voiceVolume by PropertyHandler("voice-volume")
// //
// // // Marquee Properties
// // var Style.marqueeDirection by PropertyHandler("marquee-direction")
// // var Style.marqueePlayCount by PropertyHandler("marquee-play-count")
// // var Style.marqueeSpeed by PropertyHandler("marquee-speed")
// // var Style.marqueeStyle by PropertyHandler("marquee-style")
// //
// // // Exotic
// // var Style.zoom by PropertyHandler("zoom")
// // var Style.src by PropertyHandler("src") // @font-face
