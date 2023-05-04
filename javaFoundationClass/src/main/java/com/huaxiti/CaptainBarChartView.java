//package com.com.huaxiti;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.util.AttributeSet;
//import android.view.View;
//
//import androidx.annotation.ColorInt;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.core.content.ContextCompat;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//
///**
// * @version 1.0.0
// * @autor captain:l
// * @single create by 2023年-01月
// */
//public class CaptainBarChartView extends View {
//
//    private int mAttrBgColor;
//    private int mAttrRulerColor;
//    private int mAttrBarUpColor;
//    private int mAttrBarDownColor;
//    private int mAttrYRulerCount;//y轴上的横线个数
//    private int mAttrXRulerCount;//x轴上的竖线个数
//
//    private int mAttrXTextColor;
//    private int mAttrXTextSize;
//    private int mAttrYTextColor;
//    private int mAttrYTextSize;
//
//    private Paint mPaintRuler;
//    private Paint mPaintBarUp;
//    private Paint mPaintBarDown;
//    private Paint mPaintXText;
//    private Paint mPaintYText;
//
//    private int mPaddingBoottomTextToTable = dp2px(30);//底部文本到表格的距离
//    private int mPaddingLeftTextToTable = dp2px(22);//左边文本到表格的距离
//    private int mViewStartToTable = dp2px(80);// = 自定义view左边届到表格预留的宽度 - paddingLeft
//    private int mViewBottomToTable = dp2px(50);// = 自定义view底部边届到表格预留的宽度 - paddingBottom
//    private int mTopDisplaySpace = dp2px(50);//表格上面显示信息的区域高度
//    private int mHorRulerGapSize; //y轴横线标尺间隔
//    private int mVerRulerGapSize; //x轴竖线标尺间隙
//    private float mBarWithGapWidth; //= 蜡烛宽度 + 两根蜡烛间隙宽度
//    private float mBarWidth;//蜡烛宽度
//    private int mBarGapWidth = dp2px(2);//蜡烛间隙宽度
//    private int mBarNum;//蜡烛数量 = 蜡烛数据集合的size
//    private int mTableHeight;
//    private int mTableWidth;
//
//
//    private ArrayList<BarModel> mDatas = new ArrayList();//外部传入的蜡烛图数据
//    private ArrayList<String> mTimeDatas = new ArrayList();
//    private ArrayList<Double> mValueDatas = new ArrayList();
//
//    public void setDatas(@NonNull ArrayList<BarModel> datas){
//        mDatas = datas;
//        if(mDatas.size() > 0){
//            convertDataToNeed(mDatas);
//        }
//        postInvalidate();
//    }
//
//    public void convertDataToNeed(ArrayList<BarModel> datas){
//        datasToValueDatas(datas);
//        datasTotimeDatas(datas);
//    }
//
//    private void datasTotimeDatas(ArrayList<BarModel> datas) {
//        mTimeDatas.clear();
//        for(int i = 0; i < datas.size(); i++){
//            mTimeDatas.add(datas.get(i).getTradeDate());
//        }
//    }
//
//    private void datasToValueDatas(ArrayList<BarModel> datas) {
//        mValueDatas.clear();
//        for(int i = 0; i < datas.size(); i++){
//            mValueDatas.add(datas.get(i).getHighPrice());
//            mValueDatas.add(datas.get(i).getLowPrice());
//        }
//        getNeedValues();//获取y轴坐标的最大和最小值
//    }
//
//    Double[] values = new Double[2];
//    private void getNeedValues() {
//        Iterator<Double> iterator = mValueDatas.iterator();
//        if(!iterator.hasNext()){
//            values[0] = null;
//            values[1] = null;
//            return;
//        }
//        Double max = iterator.next();
//        Double min = iterator.next();
//        while(iterator.hasNext()) {
//            Double e = iterator.next();
//            max = getMax(max, e);
//            min = getMin(min, e);
//        }
//        values[0] = max;
//        values[1] = min;
//    }
//
//    private Double getMin(Double min, Double e) {
//        return min < e ? min : e;
//    }
//
//    private Double getMax(Double max, Double e) {
//        return max > e ? max : e;
//    }
//
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//    }
//
//
//    @Override
//    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//        super.onLayout(changed, left, top, right, bottom);
//        mTableWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight() - mViewStartToTable;
//        mTableHeight = getMeasuredHeight() - getPaddingTop() - getPaddingBottom()  - mTopDisplaySpace - mViewBottomToTable;
//        //获取y轴两根横线之间的距离
//        mHorRulerGapSize = mTableWidth / (mAttrYRulerCount - 1);
//        //获取x轴两根竖线之间的距离
//        mVerRulerGapSize = mTableHeight / (mAttrXRulerCount - 1);
//        //获取蜡烛+蜡烛间隙的宽度
//        mBarWithGapWidth = (float)mTableWidth / mBarNum;
//        //获取蜡烛的宽度
//        mBarWidth = mBarWithGapWidth - mBarGapWidth;
//
//    }
//
//
//
//    private void translationKtx(Canvas canvas, int x, int y, Block block){
//        int checkpoint = canvas.save();
//        canvas.translate(x, y);
//        try {
//            block.withTranslation();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            canvas.restoreToCount(checkpoint);
//        }
//    }
//
//    private void translationFrom0_0(Canvas canvas, Block block){
//        translationKtx(canvas, getPaddingLeft(), getPaddingTop(), block);
//    }
//
//    private void translationFromX_Y(Canvas canvas, int x, int y, Block block){
//        translationKtx(canvas, x + getPaddingLeft(), y + getPaddingTop(), block);
//    }
//
//
//    public CaptainBarChartView(Context context) {
//        this(context, null);
//    }
//
//    public CaptainBarChartView(Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public CaptainBarChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        initAttrs(context, attrs);
//        initPaints();
//    }
//
//    private void initPaints() {
//        initPaint_Line(mPaintRuler, mAttrRulerColor);
//        initPaint_Fill(mPaintBarUp, mAttrBarUpColor);
//        initPaint_Fill(mPaintBarDown, mAttrBarDownColor);
//        initPaint_Text(mPaintXText, mAttrXTextColor, mAttrXTextSize);
//        initPaint_Text(mPaintYText, mAttrYTextColor, mAttrYTextSize);
//    }
//
//    private void initPaint_Line(Paint paint, @ColorInt int color){
//        paint = new Paint();
//        paint.setColor(color);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth((float)dp2px(1));
//        paint.setAntiAlias(true);
//    }
//    private void initPaint_Text(Paint paint, @ColorInt int color, float textSize){
//        paint = new Paint();
//        paint.setColor(color);
//        paint.setTextSize(textSize);
//        paint.setAntiAlias(true);
//    }
//    private void initPaint_Fill(Paint paint, @ColorInt int color){
//        paint = new Paint();
//        paint.setColor(color);
//        paint.setStyle(Paint.Style.FILL);
//        paint.setAntiAlias(true);
//    }
//
//
//    private void initAttrs(Context context, AttributeSet attrs) {
//        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CaptainBarChartView);
//        mAttrBgColor = array.getColor(R.styleable.CaptainBarChartView_bgColor,  ContextCompat.getColor(context, R.color.color_EFEFEF));
//        mAttrRulerColor = array.getColor(R.styleable.CaptainBarChartView_rulerColor,  ContextCompat.getColor(context, R.color.color_BBBBBB));
//        mAttrBarUpColor = array.getColor(R.styleable.CaptainBarChartView_barUpColor,  ContextCompat.getColor(context, R.color.color_00DE00));
//        mAttrBarDownColor = array.getColor(R.styleable.CaptainBarChartView_barDownColor,  ContextCompat.getColor(context, R.color.color_FF3434));
//        mAttrYRulerCount = array.getInt(R.styleable.CaptainBarChartView_yRulerCount,  6);
//        mAttrXRulerCount = array.getInt(R.styleable.CaptainBarChartView_xRulerCount,  5);
//
//        mAttrXTextColor = array.getColor(R.styleable.CaptainBarChartView_xTextColor,  ContextCompat.getColor(context, R.color.color_BBBBBB));
//        mAttrXTextSize = array.getColor(R.styleable.CaptainBarChartView_xTextSize,  sp2px(18));
//        mAttrYTextColor = array.getColor(R.styleable.CaptainBarChartView_yTextColor,  ContextCompat.getColor(context, R.color.color_BBBBBB));
//        mAttrYTextSize = array.getColor(R.styleable.CaptainBarChartView_yTextSize,  sp2px(18));
//        array.recycle();
//    }
//
//
//    private int dp2px(int dp){
//        float density = getContext().getResources().getDisplayMetrics().density;
//        return (int) (dp * density + 0.5f);
//    }
//
//    private int sp2px(float spValue) {
//        float density = getContext().getResources().getDisplayMetrics().scaledDensity;
//        return (int) (spValue * density + 0.5f);
//    }
//
//    interface Block{
//        void withTranslation();
//    }
//
//
//
//
//
//}
