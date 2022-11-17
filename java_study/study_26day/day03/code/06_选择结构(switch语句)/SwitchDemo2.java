/*
	ע������
		A:case����ֻ���ǳ����������Ǳ��������ң����case�����ֵ���ܳ�����ͬ��
		B:default����ʡ����
			����ʡ�ԡ�һ�㲻���顣�����жϵ�ֵ�ǹ̶��ġ�
		C:break����ʡ����
			���ԡ����һ���϶���û���κ�����ġ�
			�м��ʡ��Ҳ�ǿ��Եģ����ǲ����飬��Ϊ���ܶ�������Ҫ�Ľ������Ӱ�졣
		D:default��λ��һ��Ҫ�������
			��һ�����������κκ�case���Ӧ��λ�á�
			���ǣ����ʱ����ü���break��
		E:switch���Ľ�������
			a:����break��
			b:ִ�е������ĩβ
*/
class SwitchDemo2 {
	public static void main(String[] args) {
		int week = 3;
		//int y = 4;

		switch(week) {
			case 1:
				System.out.println(1);
				break;
			case 2:
				System.out.println(2);
				break;

			case 3:
				System.out.println(3);
				break;
			case 4:
				System.out.println(4);
				break;
			/*
			default:
				System.out.println(5);
				//break;
			*/
			default:
				System.out.println(5);
		}
	}
}
