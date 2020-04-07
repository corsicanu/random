package android.view;

import android.annotation.UnsupportedAppUsage;
import android.graphics.Rect;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.IRecentsAnimationController;

public interface IRecentsAnimationRunner extends IInterface {

    public static class Default implements IRecentsAnimationRunner {
        public IBinder asBinder() {
            return null;
        }

        public void onAnimationCanceled(boolean z) throws RemoteException {
        }

        public void onAnimationStart(IRecentsAnimationController iRecentsAnimationController, RemoteAnimationTarget[] remoteAnimationTargetArr, Rect rect, Rect rect2) throws RemoteException {
        }

        public void reportAllDrawn() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRecentsAnimationRunner {
        private static final String DESCRIPTOR = "android.view.IRecentsAnimationRunner";
        static final int TRANSACTION_onAnimationCanceled = 2;
        static final int TRANSACTION_onAnimationStart = 3;
        static final int TRANSACTION_reportAllDrawn = 4;

        private static class Proxy implements IRecentsAnimationRunner {
            public static IRecentsAnimationRunner sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onAnimationCanceled(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onAnimationCanceled(z);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onAnimationStart(IRecentsAnimationController iRecentsAnimationController, RemoteAnimationTarget[] remoteAnimationTargetArr, Rect rect, Rect rect2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRecentsAnimationController != null ? iRecentsAnimationController.asBinder() : null);
                    obtain.writeTypedArray(remoteAnimationTargetArr, 0);
                    if (rect != null) {
                        obtain.writeInt(1);
                        rect.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (rect2 != null) {
                        obtain.writeInt(1);
                        rect2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onAnimationStart(iRecentsAnimationController, remoteAnimationTargetArr, rect, rect2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void reportAllDrawn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(4, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().reportAllDrawn();
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRecentsAnimationRunner asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRecentsAnimationRunner)) ? new Proxy(iBinder) : (IRecentsAnimationRunner) queryLocalInterface;
        }

        public static IRecentsAnimationRunner getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static String getDefaultTransactionName(int i) {
            if (i == 2) {
                return "onAnimationCanceled";
            }
            if (i == 3) {
                return "onAnimationStart";
            }
            if (i != 4) {
                return null;
            }
            return "reportAllDrawn";
        }

        public static boolean setDefaultImpl(IRecentsAnimationRunner iRecentsAnimationRunner) {
            if (Proxy.sDefaultImpl != null || iRecentsAnimationRunner == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRecentsAnimationRunner;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public String getTransactionName(int i) {
            return getDefaultTransactionName(i);
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onAnimationCanceled(parcel.readInt() != 0);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onAnimationStart(IRecentsAnimationController.Stub.asInterface(parcel.readStrongBinder()), (RemoteAnimationTarget[]) parcel.createTypedArray(RemoteAnimationTarget.CREATOR), parcel.readInt() != 0 ? Rect.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Rect.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                reportAllDrawn();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    @UnsupportedAppUsage
    void onAnimationCanceled(boolean z) throws RemoteException;

    @UnsupportedAppUsage
    void onAnimationStart(IRecentsAnimationController iRecentsAnimationController, RemoteAnimationTarget[] remoteAnimationTargetArr, Rect rect, Rect rect2) throws RemoteException;

    void reportAllDrawn() throws RemoteException;
}
